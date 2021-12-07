package br.com.impacta.doe.doe.application.domain.pessoa;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class PessoaFisica {
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

    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String sexo;
    @OneToOne(cascade=CascadeType.PERSIST)
    private Nacionalidade nacionalidade;
    private String registro;

    public PessoaFisica() {
    }
}
