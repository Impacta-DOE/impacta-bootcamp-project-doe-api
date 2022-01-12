package br.com.impacta.doe.doe.application.service.pessoa.juridica;

import br.com.impacta.doe.doe.application.domain.pessoa.PessoaJuridica;
import br.com.impacta.doe.doe.infra.bucket.ImagemService;
import br.com.impacta.doe.doe.infra.database.pessoa.PessoaJuridicoRepository;
import br.com.impacta.doe.doe.infra.http.usuario.UsuarioRepository;
import br.com.impacta.doe.doe.web.pessoa.juridica.PessoaJuridicaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class PessoaJuridicaServiceImpl implements PessoaJuridicaService {
    private PessoaJuridicoRepository repository;
    private ImagemService imagemService;
    private UsuarioRepository usuarioRepository;

    @Autowired
    public PessoaJuridicaServiceImpl(PessoaJuridicoRepository repository, ImagemService imagemService, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.imagemService = imagemService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public PessoaJuridicaDto salva(PessoaJuridicaDto dto) throws IOException {
        PessoaJuridica pessoaJuridica = dto.converte();

        String idDoUsuario = usuarioRepository.salvaUsuario(dto.getUsername(), dto.getSenha());
        pessoaJuridica.setIdUsuario(idDoUsuario);

        repository.save(pessoaJuridica);
        return new PessoaJuridicaDto(pessoaJuridica, dto.getUsername());
    }

    @Override
    public ResponseEntity<PessoaJuridicaDto> atualiza(Long id, PessoaJuridicaDto dto) throws IOException {
        Optional<PessoaJuridica> pessoaOptional = repository.findById(id);
        if (pessoaOptional.isPresent()) {
            PessoaJuridica pessoaJuridica = dto.converte();
            pessoaJuridica.setId(id);
            pessoaJuridica.setIdUsuario(pessoaOptional.get().getIdUsuario());
            repository.save(pessoaJuridica);
            return ResponseEntity.ok(new PessoaJuridicaDto(pessoaJuridica, dto.getUsername()));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public String uploadImagem(Long id, MultipartFile img_avatar, MultipartFile img_background) throws IOException {
        Optional<PessoaJuridica> pessoaOptional = repository.findById(id);
        if (pessoaOptional.isPresent()) {
            PessoaJuridica pessoaJuridica = pessoaOptional.get();
            pessoaJuridica.setImg_avatar(imagemService.upload(img_avatar));
            pessoaJuridica.setImg_background(imagemService.upload(img_background));
            repository.save(pessoaJuridica);
            return "Sucesso";
        }
        return "Algo deu errado";
    }
}
