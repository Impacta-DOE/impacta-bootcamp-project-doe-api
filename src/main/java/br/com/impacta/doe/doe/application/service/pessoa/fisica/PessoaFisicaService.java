package br.com.impacta.doe.doe.application.service.pessoa.fisica;

import br.com.impacta.doe.doe.web.pessoa.fisica.PessoaFisicaDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface PessoaFisicaService {
    PessoaFisicaDto salva(PessoaFisicaDto dto) throws JsonProcessingException;

    ResponseEntity<PessoaFisicaDto> atualiza(Long id, PessoaFisicaDto dto);
}
