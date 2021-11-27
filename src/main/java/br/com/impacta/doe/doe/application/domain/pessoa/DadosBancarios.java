package br.com.impacta.doe.doe.application.domain.pessoa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DadosBancarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String banco;
    private String agencia;
    private String conta;
    private String codigoBanco;
}
