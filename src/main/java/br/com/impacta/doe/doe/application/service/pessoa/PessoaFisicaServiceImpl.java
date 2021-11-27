package br.com.impacta.doe.doe.application.service.pessoa;

import br.com.impacta.doe.doe.application.domain.pessoa.PessoaFisica;
import br.com.impacta.doe.doe.infra.database.pessoa.PessoaFisicaRepository;
import br.com.impacta.doe.doe.web.pessoa.fisica.PessoaFisicaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaFisicaServiceImpl implements PessoaFisicaService {
    private PessoaFisicaRepository repository;

    @Autowired
    public PessoaFisicaServiceImpl(PessoaFisicaRepository repository) {
        this.repository = repository;
    }

    @Override
    public PessoaFisicaDto salva(PessoaFisicaDto dto) {
        PessoaFisica pessoaFisica = dto.converte();
        repository.save(pessoaFisica);
        return new PessoaFisicaDto(pessoaFisica);
    }

    @Override
    public ResponseEntity<PessoaFisicaDto> atualiza(Long id, PessoaFisicaDto dto) {
        Optional<PessoaFisica> pessoaOptional = repository.findById(id);
        if (pessoaOptional.isPresent()) {
            PessoaFisica pessoaFisica = dto.converte();
            pessoaFisica.setId(id);
            repository.save(pessoaFisica);
            return ResponseEntity.ok(new PessoaFisicaDto(pessoaFisica));
        }
        return ResponseEntity.notFound().build();
    }
}
