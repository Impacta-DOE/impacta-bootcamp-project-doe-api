package br.com.impacta.doe.doe.web.pessoa;

import br.com.impacta.doe.doe.application.domain.pessoa.Pessoa;
import br.com.impacta.doe.doe.application.service.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public PessoaDto salva(@RequestBody PessoaDto pessoaDto) {
        Pessoa pessoa = pessoaService.salva(pessoaDto);
        return new PessoaDto(pessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDto> atualiza(@PathVariable Long id, @RequestBody PessoaDto pessoaDto) {
        Optional<Pessoa> pessoaOptional = pessoaService.atualiza(id, pessoaDto);
        if (pessoaOptional.isPresent())
            return ResponseEntity.ok(new PessoaDto(pessoaOptional.get()));
        return ResponseEntity.notFound().build();
    }
}
