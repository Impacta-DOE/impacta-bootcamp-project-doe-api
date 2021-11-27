package br.com.impacta.doe.doe.web.pessoa.juridica;

import br.com.impacta.doe.doe.application.domain.pessoa.PessoaJuridica;
import br.com.impacta.doe.doe.web.pessoa.DadosBancariosDto;
import br.com.impacta.doe.doe.web.pessoa.DadosContatoDto;
import br.com.impacta.doe.doe.web.pessoa.EnderecoDto;
import lombok.Data;

@Data
public class PessoaJuridicaDto {
    private String cnpj;
    private String razaoSocial;
    private EnderecoDto endereco;
    private DadosBancariosDto dadosBancarios;
    private DadosContatoDto dadosContato;

    public PessoaJuridicaDto() {
    }

    public PessoaJuridicaDto(PessoaJuridica pessoaJuridica) {
        this.cnpj = pessoaJuridica.getCnpj();
        this.razaoSocial = pessoaJuridica.getRazaoSocial();
        this.endereco = new EnderecoDto(pessoaJuridica.getEndereco());
        this.dadosBancarios = new DadosBancariosDto(pessoaJuridica.getDadosBancarios());
        this.dadosContato = new DadosContatoDto(pessoaJuridica.getDadosContato());
    }

    public PessoaJuridica converte() {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setCnpj(this.cnpj);
        pessoaJuridica.setRazaoSocial(this.razaoSocial);
        pessoaJuridica.setEndereco(this.endereco.converte());
        pessoaJuridica.setDadosContato(this.dadosContato.converte());
        pessoaJuridica.setDadosBancarios(this.dadosBancarios.converte());
        return pessoaJuridica;
    }
}
