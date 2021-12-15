package br.com.impacta.doe.doe.application.service.pessoa.juridica;

import br.com.impacta.doe.doe.web.pessoa.juridica.PessoaJuridicaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PessoaJuridicaService {
    PessoaJuridicaDto salva(PessoaJuridicaDto dto) throws IOException;

    ResponseEntity<PessoaJuridicaDto> atualiza(Long id, PessoaJuridicaDto dto, MultipartFile img_avatar, MultipartFile img_background) throws IOException;
}
