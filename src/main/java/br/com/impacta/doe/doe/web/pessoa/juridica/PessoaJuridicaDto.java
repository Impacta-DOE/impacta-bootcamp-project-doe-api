package br.com.impacta.doe.doe.web.pessoa.juridica;

import br.com.impacta.doe.doe.application.domain.pessoa.PessoaJuridica;
import br.com.impacta.doe.doe.web.pessoa.DadosBancariosDto;
import br.com.impacta.doe.doe.web.pessoa.DadosContatoDto;
import br.com.impacta.doe.doe.web.pessoa.EnderecoDto;
import lombok.Data;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Data
public class PessoaJuridicaDto {
    private Long id;
    private DadosContatoDto dadosContato;
    private DadosBancariosDto dadosBancarios;
    private EnderecoDto endereco;
    private String senha;
    private Base64 img_avatar_base64;
    private Base64 img_background_base64;
    private String img_avatar_url;
    private String img_background_url;
    private String idUsuario;
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
        this.img_avatar_url = pessoaJuridica.getImg_avatar();
        this.img_background_url = pessoaJuridica.getImg_background();
        this.idUsuario = pessoaJuridica.getIdUsuario();
        this.endereco = new EnderecoDto(pessoaJuridica.getEndereco());
        this.dadosBancarios = new DadosBancariosDto(pessoaJuridica.getDadosBancarios());
        this.dadosContato = new DadosContatoDto(pessoaJuridica.getDadosContato());
    }

    public PessoaJuridica converte() {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setCnpj(this.cnpj);
        pessoaJuridica.setRazaoSocial(this.razaoSocial);
        pessoaJuridica.setSenha(this.senha);
        pessoaJuridica.setIdUsuario(this.idUsuario);
        pessoaJuridica.setEndereco(this.endereco.converte());
        pessoaJuridica.setDadosContato(this.dadosContato.converte());
        pessoaJuridica.setDadosBancarios(this.dadosBancarios.converte());
        return pessoaJuridica;
    }
}
