package br.com.impacta.doe.doe.application.service.pessoa.fisica;

import br.com.impacta.doe.doe.application.domain.pessoa.PessoaFisica;
import br.com.impacta.doe.doe.infra.bucket.ImagemService;
import br.com.impacta.doe.doe.infra.database.pessoa.PessoaFisicaRepository;
import br.com.impacta.doe.doe.infra.http.usuario.UsuarioRepository;
import br.com.impacta.doe.doe.web.pessoa.fisica.PessoaFisicaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public PessoaFisicaDto salva(PessoaFisicaDto dto) throws IOException {
        PessoaFisica pessoaFisica = dto.converte();

        String idDoUsuario = usuarioRepository.salvaUsuario(dto.getUsername(), dto.getSenha());
        pessoaFisica.setIdUsuario(idDoUsuario);

        repository.save(pessoaFisica);
        return new PessoaFisicaDto(pessoaFisica, dto.getUsername());
    }

    @Override
    public ResponseEntity<PessoaFisicaDto> atualiza(Long id, PessoaFisicaDto dto, MultipartFile img_avatar, MultipartFile img_background) throws IOException {
        Optional<PessoaFisica> pessoaOptional = repository.findById(id);
        if (pessoaOptional.isPresent()) {
            PessoaFisica pessoaFisica = dto.converte();
            pessoaFisica.setId(id);
            PessoaFisica pessoaFisicaComUrlsDeImagens = getPessoaFisicaComUrlsDeImagens(img_avatar, img_background, pessoaFisica);
            repository.save(pessoaFisicaComUrlsDeImagens);
            return ResponseEntity.ok(new PessoaFisicaDto(pessoaFisicaComUrlsDeImagens, dto.getUsername()));
        }
        return ResponseEntity.notFound().build();
    }

    private PessoaFisica getPessoaFisicaComUrlsDeImagens(MultipartFile img_avatar, MultipartFile img_background, PessoaFisica pessoaFisica) throws IOException {
        if (img_avatar != null) {
            String urlAvatar = imagemService.upload(img_avatar);
            pessoaFisica.setImg_avatar(urlAvatar);
        }
        if (img_background != null) {
            String urlBackground = imagemService.upload(img_background);
            pessoaFisica.setImg_background(urlBackground);
        }
        return pessoaFisica;
    }
}
