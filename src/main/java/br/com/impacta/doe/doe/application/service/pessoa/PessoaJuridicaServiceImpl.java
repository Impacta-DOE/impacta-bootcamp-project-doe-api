package br.com.impacta.doe.doe.application.service.pessoa;

import br.com.impacta.doe.doe.application.domain.pessoa.PessoaJuridica;
import br.com.impacta.doe.doe.infra.database.pessoa.PessoaJuridicoRepository;
import br.com.impacta.doe.doe.web.pessoa.juridica.PessoaJuridicaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaJuridicaServiceImpl implements PessoaJuridicaService {
    private PessoaJuridicoRepository repository;

    @Autowired
    public PessoaJuridicaServiceImpl(PessoaJuridicoRepository repository) {
        this.repository = repository;
    }

    @Override
    public PessoaJuridicaDto salva(PessoaJuridicaDto dto) {
        PessoaJuridica pessoaJuridica = dto.converte();
        repository.save(pessoaJuridica);
        return new PessoaJuridicaDto(pessoaJuridica);
    }

    @Override
    public ResponseEntity<PessoaJuridicaDto> atualiza(Long id, PessoaJuridicaDto dto) {
        Optional<PessoaJuridica> pessoaOptional = repository.findById(id);
        if (pessoaOptional.isPresent()) {
            PessoaJuridica pessoaJuridica = dto.converte();
            pessoaJuridica.setId(id);
            repository.save(pessoaJuridica);
            return ResponseEntity.ok(new PessoaJuridicaDto(pessoaJuridica));
        }
        return ResponseEntity.notFound().build();
    }
}
