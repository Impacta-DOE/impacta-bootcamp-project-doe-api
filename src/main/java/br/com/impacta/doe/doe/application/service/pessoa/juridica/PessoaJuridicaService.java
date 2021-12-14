package br.com.impacta.doe.doe.application.service.pessoa.juridica;

import br.com.impacta.doe.doe.web.pessoa.juridica.PessoaJuridicaDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface PessoaJuridicaService {
    PessoaJuridicaDto salva(PessoaJuridicaDto dto) throws JsonProcessingException;

    ResponseEntity<PessoaJuridicaDto> atualiza(Long id, PessoaJuridicaDto dto);
}
