package br.com.impacta.doe.doe.application.domain.pessoa;

import java.time.LocalDate;

public class Pessoa {
    private String id;
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
