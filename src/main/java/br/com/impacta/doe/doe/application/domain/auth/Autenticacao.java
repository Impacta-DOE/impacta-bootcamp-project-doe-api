package br.com.impacta.doe.doe.application.domain.auth;

import br.com.impacta.doe.doe.application.domain.pessoa.PessoaFisica;
import br.com.impacta.doe.doe.application.domain.pessoa.PessoaJuridica;

import javax.persistence.*;

@Entity
public class Autenticacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private PessoaFisica pessoaFisica;

    @OneToOne
    private PessoaJuridica pessoaJuridica;

    private String passwordHash;
    private String passwordSalt;

    public Autenticacao() {}
}
