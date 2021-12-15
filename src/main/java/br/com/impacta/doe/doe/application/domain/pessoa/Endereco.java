package br.com.impacta.doe.doe.application.domain.pessoa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private String idDaCidade;
    private String idDoEstado;
    private String uf;
    private String complemento;
}
