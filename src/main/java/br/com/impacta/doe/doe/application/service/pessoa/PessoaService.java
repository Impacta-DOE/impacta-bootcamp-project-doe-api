package br.com.impacta.doe.doe.application.service.pessoa;

import br.com.impacta.doe.doe.application.domain.pessoa.Pessoa;
import br.com.impacta.doe.doe.web.pessoa.PessoaDto;

import java.util.Optional;

public interface PessoaService {
    Pessoa salva(PessoaDto pessoaDto);

    Optional<Pessoa> atualiza(Long id, PessoaDto pessoaDto);
}
