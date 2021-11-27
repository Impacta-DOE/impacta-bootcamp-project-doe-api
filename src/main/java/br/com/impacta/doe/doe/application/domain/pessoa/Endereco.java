package br.com.impacta.doe.doe.application.domain.pessoa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String complemento;
}
