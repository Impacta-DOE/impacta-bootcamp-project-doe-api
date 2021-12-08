package br.com.impacta.doe.doe.application.domain.pessoa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PessoaJuridica {
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

    private String cnpj;
    private String razaoSocial;
    private String subtituloOrganizacao;
    private String idUsuario;

    public PessoaJuridica() {
    }
}
