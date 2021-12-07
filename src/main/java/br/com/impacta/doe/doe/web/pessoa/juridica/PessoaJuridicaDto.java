package br.com.impacta.doe.doe.web.pessoa.juridica;

import br.com.impacta.doe.doe.application.domain.pessoa.PessoaJuridica;
import br.com.impacta.doe.doe.web.pessoa.DadosBancariosDto;
import br.com.impacta.doe.doe.web.pessoa.DadosContatoDto;
import br.com.impacta.doe.doe.web.pessoa.EnderecoDto;
import lombok.Data;

@Data
public class PessoaJuridicaDto {
    private Long id;
    private DadosContatoDto dadosContato;
    private DadosBancariosDto dadosBancarios;
    private EnderecoDto endereco;
    private String senha;
    private String img_avatar;
    private String img_background;
    private String cnpj;
    private String razaoSocial;
    private String subtituloOrganizacao;

    public PessoaJuridicaDto() {
    }

    public PessoaJuridicaDto(PessoaJuridica pessoaJuridica) {
        this.id = pessoaJuridica.getId();
        this.cnpj = pessoaJuridica.getCnpj();
        this.razaoSocial = pessoaJuridica.getRazaoSocial();
        this.senha = pessoaJuridica.getSenha();
        this.img_avatar = pessoaJuridica.getImg_avatar();
        this.img_background = pessoaJuridica.getImg_background();
        this.endereco = new EnderecoDto(pessoaJuridica.getEndereco());
        this.dadosBancarios = new DadosBancariosDto(pessoaJuridica.getDadosBancarios());
        this.dadosContato = new DadosContatoDto(pessoaJuridica.getDadosContato());
    }

    public PessoaJuridica converte() {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setCnpj(this.cnpj);
        pessoaJuridica.setRazaoSocial(this.razaoSocial);
        pessoaJuridica.setSenha(this.senha);
        pessoaJuridica.setImg_avatar(this.img_avatar);
        pessoaJuridica.setImg_background(this.img_background);
        pessoaJuridica.setEndereco(this.endereco.converte());
        pessoaJuridica.setDadosContato(this.dadosContato.converte());
        pessoaJuridica.setDadosBancarios(this.dadosBancarios.converte());
        return pessoaJuridica;
    }
}
