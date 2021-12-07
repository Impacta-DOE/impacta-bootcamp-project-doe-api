package br.com.impacta.doe.doe.application.domain.pessoa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PessoaJuridica {
    //TODO: extrair estes atributos para uma classe pessoa e utilizar herança
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade=CascadeType.PERSIST)
    private DadosContato dadosContato;
    @OneToOne(cascade=CascadeType.PERSIST)
    private DadosBancarios dadosBancarios;
    @OneToOne(cascade=CascadeType.PERSIST)
    private Endereco endereco;

    private String cnpj;
    private String razaoSocial;

    public PessoaJuridica() {
    }
}
