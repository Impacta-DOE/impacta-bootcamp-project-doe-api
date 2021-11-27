package br.com.impacta.doe.doe.web.pessoa;

import br.com.impacta.doe.doe.application.domain.pessoa.Endereco;
import lombok.Data;

@Data
public class EnderecoDto {
    private Long id;
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String complemento;

    public EnderecoDto() {
    }

    public EnderecoDto(Endereco endereco) {
        this.id = endereco.getId();
        this.cep = endereco.getCep();
        this.logradouro = endereco.getLogradouro();
        this.numero = endereco.getNumero();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.uf = endereco.getUf();
        this.complemento = endereco.getComplemento();
    }

    public Endereco converte() {
        Endereco endereco = new Endereco();
        endereco.setBairro(this.bairro);
        endereco.setCep(this.cep);
        endereco.setCidade(this.cidade);
        endereco.setId(this.id);
        endereco.setComplemento(this.complemento);
        endereco.setLogradouro(this.logradouro);
        endereco.setNumero(this.numero);
        endereco.setUf(this.uf);
        return endereco;
    }
}
