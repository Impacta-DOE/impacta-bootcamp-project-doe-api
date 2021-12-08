package br.com.impacta.doe.doe.application.service.pessoa.juridica;

import br.com.impacta.doe.doe.web.pessoa.juridica.PessoaJuridicaDto;
import org.springframework.http.ResponseEntity;

public interface PessoaJuridicaService {
    PessoaJuridicaDto salva(PessoaJuridicaDto dto);

    ResponseEntity<PessoaJuridicaDto> atualiza(Long id, PessoaJuridicaDto dto);
}
