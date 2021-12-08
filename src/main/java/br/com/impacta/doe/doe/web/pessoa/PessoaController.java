package br.com.impacta.doe.doe.web.pessoa;

import br.com.impacta.doe.doe.application.service.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa/usuario")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("{id}")
    public IdPessoaDto buscaPessoaPorUsuario(@PathVariable String id){
        return pessoaService.buscaPessoaPorUsuario(id);
    }

}
