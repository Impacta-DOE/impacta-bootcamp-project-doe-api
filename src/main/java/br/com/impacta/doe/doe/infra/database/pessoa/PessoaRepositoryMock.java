package br.com.impacta.doe.doe.infra.database.pessoa;

import br.com.impacta.doe.doe.application.domain.pessoa.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class PessoaRepositoryMock implements PessoaRepository {
    private Map<Long, Pessoa> DATABASE = new HashMap<>();
    private Long ID = 0L;

    @Override
    public Pessoa salva(Pessoa pessoa) {
        ID = ID + 1;
        pessoa.setId(ID);
        DATABASE.put(ID, pessoa);
        return pessoa;
    }

    @Override
    public Optional<Pessoa> atualiza(Pessoa pessoa) {
        Pessoa pessoaAtualizada = DATABASE.put(pessoa.getId(), pessoa);
        return Optional.of(pessoaAtualizada);
    }

    @Override
    public Optional<Pessoa> buscaPorId(Long id) {
        Pessoa pessoa = DATABASE.get(id);
        return Optional.of(pessoa);
    }
}
