package br.com.impacta.doe.doe.application.domain.auth;

import br.com.impacta.doe.doe.application.domain.pessoa.Pessoa;

import javax.persistence.*;

@Entity
public class Autenticacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Pessoa pessoa;

    private String passwordHash;
    private String passwordSalt;

    public Autenticacao() {}
}
