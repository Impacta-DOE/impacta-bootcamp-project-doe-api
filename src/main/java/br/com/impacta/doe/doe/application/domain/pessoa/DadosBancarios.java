package br.com.impacta.doe.doe.application.domain.pessoa;

import javax.persistence.*;

@Entity
public class DadosBancarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private TipoConta tipoConta;
    @OneToOne
    private Pessoa pessoa;
    private String banco;
    private String agencia;
    private String conta;
    private String digitoConta;
}
