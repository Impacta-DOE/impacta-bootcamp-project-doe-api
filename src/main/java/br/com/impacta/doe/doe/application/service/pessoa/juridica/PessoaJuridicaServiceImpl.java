package br.com.impacta.doe.doe.application.service.pessoa.juridica;

import br.com.impacta.doe.doe.application.domain.pessoa.PessoaJuridica;
import br.com.impacta.doe.doe.infra.bucket.ImagemService;
import br.com.impacta.doe.doe.infra.database.pessoa.PessoaJuridicoRepository;
import br.com.impacta.doe.doe.web.pessoa.juridica.PessoaJuridicaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaJuridicaServiceImpl implements PessoaJuridicaService {
    private PessoaJuridicoRepository repository;
    private ImagemService imagemService;

    @Autowired
    public PessoaJuridicaServiceImpl(PessoaJuridicoRepository repository,
                                     ImagemService imagemService) {
        this.imagemService = imagemService;
        this.repository = repository;
    }

    @Override
    public PessoaJuridicaDto salva(PessoaJuridicaDto dto) {
        PessoaJuridica pessoaJuridica = dto.converte();
        PessoaJuridica pessoaJuridicaComUrlsDeImagens = getPessoaJuridicaComUrlsDeImagens(dto, pessoaJuridica);
        repository.save(pessoaJuridicaComUrlsDeImagens);
        return new PessoaJuridicaDto(pessoaJuridicaComUrlsDeImagens);
    }

    @Override
    public ResponseEntity<PessoaJuridicaDto> atualiza(Long id, PessoaJuridicaDto dto) {
        Optional<PessoaJuridica> pessoaOptional = repository.findById(id);
        if (pessoaOptional.isPresent()) {
            PessoaJuridica pessoaJuridica = dto.converte();
            pessoaJuridica.setId(id);
            PessoaJuridica pessoaJuridicaComUrlsDeImagens = getPessoaJuridicaComUrlsDeImagens(dto, pessoaJuridica);
            repository.save(pessoaJuridicaComUrlsDeImagens);
            return ResponseEntity.ok(new PessoaJuridicaDto(pessoaJuridicaComUrlsDeImagens));
        }
        return ResponseEntity.notFound().build();
    }

    private PessoaJuridica getPessoaJuridicaComUrlsDeImagens(PessoaJuridicaDto dto, PessoaJuridica pessoaJuridica) {
        if (dto.getImg_avatar_base64() != null) {
            String urlAvatar = imagemService.upload(dto.getImg_avatar_base64());
            pessoaJuridica.setImg_avatar(urlAvatar);
        }
        if (dto.getImg_background_base64() != null) {
            String urlBackground = imagemService.upload(dto.getImg_background_base64());
            pessoaJuridica.setImg_background(urlBackground);
        }
        return pessoaJuridica;
    }
}
