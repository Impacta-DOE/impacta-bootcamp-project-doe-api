package br.com.impacta.doe.doe.application.service.pessoa.fisica;

import br.com.impacta.doe.doe.application.domain.pessoa.PessoaFisica;
import br.com.impacta.doe.doe.infra.bucket.ImagemService;
import br.com.impacta.doe.doe.infra.database.pessoa.PessoaFisicaRepository;
import br.com.impacta.doe.doe.infra.http.usuario.UsuarioRepository;
import br.com.impacta.doe.doe.web.pessoa.fisica.PessoaFisicaDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaFisicaServiceImpl implements PessoaFisicaService {
    private PessoaFisicaRepository repository;
    private ImagemService imagemService;
    private UsuarioRepository usuarioRepository;

    @Autowired
    public PessoaFisicaServiceImpl(PessoaFisicaRepository repository, ImagemService imagemService, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.imagemService = imagemService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public PessoaFisicaDto salva(PessoaFisicaDto dto) throws JsonProcessingException {
        PessoaFisica pessoaFisica = dto.converte();

        String idDoUsuario = usuarioRepository.salvaUsuario(dto.getUsername(), dto.getSenha());
        pessoaFisica.setIdUsuario(idDoUsuario);

        PessoaFisica pessoaFisicaComUrlsDeImagens = getPessoaFisicaComUrlsDeImagens(dto, pessoaFisica);
        repository.save(pessoaFisicaComUrlsDeImagens);

        return new PessoaFisicaDto(pessoaFisicaComUrlsDeImagens);
    }

    @Override
    public ResponseEntity<PessoaFisicaDto> atualiza(Long id, PessoaFisicaDto dto) {
        Optional<PessoaFisica> pessoaOptional = repository.findById(id);
        if (pessoaOptional.isPresent()) {
            PessoaFisica pessoaFisica = dto.converte();
            pessoaFisica.setId(id);
            PessoaFisica pessoaFisicaComUrlsDeImagens = getPessoaFisicaComUrlsDeImagens(dto, pessoaFisica);
            repository.save(pessoaFisicaComUrlsDeImagens);
            return ResponseEntity.ok(new PessoaFisicaDto(pessoaFisicaComUrlsDeImagens));
        }
        return ResponseEntity.notFound().build();
    }

    private PessoaFisica getPessoaFisicaComUrlsDeImagens(PessoaFisicaDto dto, PessoaFisica pessoaFisica) {
        if (dto.getImg_avatar_base64() != null) {
            String urlAvatar = imagemService.upload(dto.getImg_avatar_base64());
            pessoaFisica.setImg_avatar(urlAvatar);
        }
        if (dto.getImg_background_base64() != null) {
            String urlBackground = imagemService.upload(dto.getImg_background_base64());
            pessoaFisica.setImg_background(urlBackground);
        }
        return pessoaFisica;
    }
}
