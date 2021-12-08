package br.com.impacta.doe.doe.infra.database.pessoa;

import br.com.impacta.doe.doe.application.domain.pessoa.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
    Optional<PessoaFisica> findByidUsuario(String id);
}
