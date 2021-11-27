package br.com.impacta.doe.doe.application.domain.pessoa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private DadosContato dadosContato;
    @OneToOne
    private DadosBancarios dadosBancarios;
    @OneToOne
    private Endereco endereco;

    public Pessoa() {
    }
}
