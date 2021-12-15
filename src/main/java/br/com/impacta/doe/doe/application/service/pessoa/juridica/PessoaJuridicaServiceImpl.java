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
        return new PessoaJuridicaDto(pessoaJuridica);
    }

    @Override
    public ResponseEntity<PessoaJuridicaDto> atualiza(Long id, PessoaJuridicaDto dto, MultipartFile img_avatar, MultipartFile img_background) throws IOException {
        Optional<PessoaJuridica> pessoaOptional = repository.findById(id);
        if (pessoaOptional.isPresent()) {
            PessoaJuridica pessoaJuridica = dto.converte();
            pessoaJuridica.setId(id);
            PessoaJuridica pessoaJuridicaComUrlsDeImagens = getPessoaJuridicaComUrlsDeImagens(img_avatar, img_background, pessoaJuridica);
            repository.save(pessoaJuridicaComUrlsDeImagens);
            return ResponseEntity.ok(new PessoaJuridicaDto(pessoaJuridicaComUrlsDeImagens));
        }
        return ResponseEntity.notFound().build();
    }

    private PessoaJuridica getPessoaJuridicaComUrlsDeImagens(MultipartFile img_avatar, MultipartFile img_background, PessoaJuridica pessoaJuridica) throws IOException {
        if (img_avatar != null) {
            String urlAvatar = imagemService.upload(img_avatar);
            pessoaJuridica.setImg_avatar(urlAvatar);
        }
        if (img_background != null) {
            String urlBackground = imagemService.upload(img_background);
            pessoaJuridica.setImg_background(urlBackground);
        }
        return pessoaJuridica;
    }
}
