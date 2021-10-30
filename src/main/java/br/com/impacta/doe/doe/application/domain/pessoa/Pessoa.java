package br.com.impacta.doe.doe.application.domain.pessoa;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Pessoa {
    private Long id;
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
