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
    public ResponseEntity<PessoaFisicaDto> atualiza(Long id, PessoaFisicaDto dto) throws IOException {
        Optional<PessoaFisica> pessoaOptional = repository.findById(id);
        if (pessoaOptional.isPresent()) {
            PessoaFisica pessoaFisica = dto.converte();
            pessoaFisica.setId(id);
            pessoaFisica.setIdUsuario(pessoaOptional.get().getIdUsuario());
            repository.save(pessoaFisica);
            return ResponseEntity.ok(new PessoaFisicaDto(pessoaFisica, dto.getUsername()));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public String uploadImagem(Long id, MultipartFile img_avatar, MultipartFile img_background) throws IOException {
        Optional<PessoaFisica> pessoaOptional = repository.findById(id);
        if (pessoaOptional.isPresent()) {
            PessoaFisica pessoaFisica = pessoaOptional.get();
            pessoaFisica.setImg_avatar(imagemService.upload(img_avatar));
            pessoaFisica.setImg_background(imagemService.upload(img_background));
            repository.save(pessoaFisica);
            return "Sucesso";
        }
        return "Algo deu errado";
    }
}
