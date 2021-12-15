package br.com.impacta.doe.doe.application.domain.pessoa;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class PessoaFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade=CascadeType.PERSIST)
    private DadosContato dadosContato;
    @OneToOne(cascade=CascadeType.PERSIST)
    private DadosBancarios dadosBancarios;
    @OneToOne(cascade=CascadeType.PERSIST)
    private Endereco endereco;
    private String senha;
    private String img_avatar;
    private String img_background;
    private String descricao;

    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String sexo;
    @OneToOne(cascade=CascadeType.PERSIST)
    private Nacionalidade nacionalidade;
    private String registro;
    private String idUsuario;

    public PessoaFisica() {
    }
}
