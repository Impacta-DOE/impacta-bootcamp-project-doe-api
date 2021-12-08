package br.com.impacta.doe.doe.web.pessoa.fisica;

import br.com.impacta.doe.doe.application.service.pessoa.fisica.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa/fisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService service;

    @PostMapping
    public PessoaFisicaDto salva(@RequestBody PessoaFisicaDto dto) {
        return service.salva(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaFisicaDto> atualiza(@PathVariable Long id,
                                                    @RequestBody PessoaFisicaDto dto) {
        return service.atualiza(id, dto);
    }
}
