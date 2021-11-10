package br.com.impacta.doe.doe.application.domain.pessoa;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private TipoPessoa tipoPessoa;
    private String documento;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataInclusao;
    private LocalDate dataNascimento;
    private Sexo sexo;
    private Nacionalidade nacionalidade;
    private LocalDate dataAtualizacao;
}
