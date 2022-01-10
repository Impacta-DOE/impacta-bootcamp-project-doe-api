package br.com.impacta.doe.doe.web.pessoa;

import br.com.impacta.doe.doe.application.service.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/pessoa/usuario")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/{id}/pessoa/id")
    public IdPessoaDto buscaIdDaPessoaPorUsuario(@PathVariable String id) {
        return pessoaService.buscaIdDaPessoaPorUsuario(id);
    }

    @GetMapping("/{id}/pessoa")
    public Object buscaPessoaPorUsuario(@PathVariable String id) {
        return pessoaService.buscaPessoaPorUsuario(id);
    }
}
