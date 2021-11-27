package br.com.impacta.doe.doe.application.domain.pessoa;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class PessoaJuridica extends Pessoa {
    private String cnpj;
    private String razaoSocial;

    public PessoaJuridica() {
    }
}
