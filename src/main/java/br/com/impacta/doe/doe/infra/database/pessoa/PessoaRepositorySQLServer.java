package br.com.impacta.doe.doe.infra.database.pessoa;

import br.com.impacta.doe.doe.application.domain.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepositorySQLServer extends JpaRepository<Pessoa, Long> {
}
