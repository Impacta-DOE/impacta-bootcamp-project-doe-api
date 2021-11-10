package br.com.impacta.doe.doe.application.service.pessoa;

import br.com.impacta.doe.doe.application.domain.pessoa.Pessoa;
import br.com.impacta.doe.doe.infra.database.pessoa.PessoaRepository;
import br.com.impacta.doe.doe.web.pessoa.PessoaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {
    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Pessoa salva(PessoaDto pessoaDto) {
        Pessoa pessoa = pessoaDto.converte();
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Optional<Pessoa> atualiza(Long id, PessoaDto pessoaDto) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        if (pessoaOptional.isPresent()) {
            Pessoa pessoa = pessoaDto.converte();
            pessoa.setId(id);
            return Optional.of(pessoaRepository.save(pessoa));
        }
        return Optional.empty();
    }
}
