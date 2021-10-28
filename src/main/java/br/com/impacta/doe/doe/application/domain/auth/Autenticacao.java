package br.com.impacta.doe.doe.application.domain.auth;

import br.com.impacta.doe.doe.application.domain.pessoa.Pessoa;

public class Autenticacao {
    private String id;
    private Pessoa pessoa;
    private String passwordHash;
    private String passwordSalt;
}
