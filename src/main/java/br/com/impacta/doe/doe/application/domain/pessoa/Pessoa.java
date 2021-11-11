package br.com.impacta.doe.doe.application.domain.pessoa;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;
    private String documento;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataInclusao;
    private LocalDate dataNascimento;
    private Sexo sexo;
    @OneToOne
    private Nacionalidade nacionalidade;
    private LocalDate dataAtualizacao;
}
