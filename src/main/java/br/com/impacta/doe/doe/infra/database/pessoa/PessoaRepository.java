package br.com.impacta.doe.doe.infra.database.pessoa;

import br.com.impacta.doe.doe.application.domain.pessoa.Pessoa;

import java.util.Optional;

public interface PessoaRepository {
    Pessoa salva(Pessoa pessoa);

    Optional<Pessoa> atualiza(Pessoa pessoa);

    Optional<Pessoa> buscaPorId(Long id);
}
