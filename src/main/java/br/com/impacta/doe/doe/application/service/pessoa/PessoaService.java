package br.com.impacta.doe.doe.application.service.pessoa;

import br.com.impacta.doe.doe.web.pessoa.IdPessoaDto;

public interface PessoaService {
    IdPessoaDto buscaIdDaPessoaPorUsuario(String id);

    Object buscaPessoaPorUsuario(String id);
}
