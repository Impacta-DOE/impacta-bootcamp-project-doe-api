package br.com.impacta.doe.doe.web.pessoa;

import br.com.impacta.doe.doe.application.domain.pessoa.Nacionalidade;
import br.com.impacta.doe.doe.application.domain.pessoa.Pessoa;
import br.com.impacta.doe.doe.application.domain.pessoa.Sexo;
import br.com.impacta.doe.doe.application.domain.pessoa.TipoPessoa;

import java.time.LocalDate;

public class PessoaDto {
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

    public PessoaDto(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.tipoPessoa = pessoa.getTipoPessoa();
        this.documento = pessoa.getDocumento();
        this.nome = pessoa.getNome();
        this.email = pessoa.getEmail();
        this.telefone = pessoa.getTelefone();
        this.dataInclusao = pessoa.getDataInclusao();
        this.dataNascimento = pessoa.getDataNascimento();
        this.sexo = pessoa.getSexo();
        this.nacionalidade = pessoa.getNacionalidade();
        this.dataAtualizacao = pessoa.getDataAtualizacao();
    }

    public Pessoa converte() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(this.id);
        pessoa.setTipoPessoa(this.tipoPessoa);
        pessoa.setDocumento(this.documento);
        pessoa.setNome(this.nome);
        pessoa.setEmail(this.email);
        pessoa.setTelefone(this.telefone);
        pessoa.setDataInclusao(this.dataInclusao);
        pessoa.setDataNascimento(this.dataNascimento);
        pessoa.setSexo(this.sexo);
        pessoa.setDataNascimento(this.dataNascimento);
        pessoa.setDataAtualizacao(this.dataAtualizacao);
        return pessoa;
    }
}
