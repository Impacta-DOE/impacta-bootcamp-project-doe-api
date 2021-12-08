package br.com.impacta.doe.doe.infra.database.pessoa;

import br.com.impacta.doe.doe.application.domain.pessoa.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaJuridicoRepository extends JpaRepository<PessoaJuridica, Long> {
    Optional<PessoaJuridica> findByidUsuario(String id);
}
