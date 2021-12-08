package br.com.impacta.doe.doe.application.service.pessoa.fisica;

import br.com.impacta.doe.doe.web.pessoa.fisica.PessoaFisicaDto;
import org.springframework.http.ResponseEntity;

public interface PessoaFisicaService {
    PessoaFisicaDto salva(PessoaFisicaDto dto);

    ResponseEntity<PessoaFisicaDto> atualiza(Long id, PessoaFisicaDto dto);
}
