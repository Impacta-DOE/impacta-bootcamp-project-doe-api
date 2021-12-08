package br.com.impacta.doe.doe.web.pessoa.fisica;

import br.com.impacta.doe.doe.application.domain.pessoa.PessoaFisica;
import br.com.impacta.doe.doe.web.pessoa.DadosBancariosDto;
import br.com.impacta.doe.doe.web.pessoa.DadosContatoDto;
import br.com.impacta.doe.doe.web.pessoa.EnderecoDto;
import br.com.impacta.doe.doe.web.pessoa.NacionalidadeDto;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class PessoaFisicaDto {
    private Long id;
    private DadosContatoDto dadosContato;
    private DadosBancariosDto dadosBancarios;
    private EnderecoDto endereco;
    private String senha;
    private String img_avatar;
    private String img_background;
    private String idUsuario;
    private String nomeCompleto;
    private String dataNascimento;
    private String sexo;
    private NacionalidadeDto nacionalidade;
    private String registro;

    public PessoaFisicaDto() {
    }

    public PessoaFisicaDto(PessoaFisica pessoaFisica) {
        this.id = pessoaFisica.getId();
        this.nomeCompleto = pessoaFisica.getNomeCompleto();
        this.registro = pessoaFisica.getRegistro();
        this.dataNascimento = pessoaFisica.getDataNascimento().toString();
        this.sexo = pessoaFisica.getSexo();
        this.senha = pessoaFisica.getSenha();
        this.img_avatar = pessoaFisica.getImg_avatar();
        this.img_background = pessoaFisica.getImg_background();
        this.idUsuario = pessoaFisica.getIdUsuario();
        this.nacionalidade = new NacionalidadeDto(pessoaFisica.getNacionalidade());
        this.endereco = new EnderecoDto(pessoaFisica.getEndereco());
        this.dadosBancarios = new DadosBancariosDto(pessoaFisica.getDadosBancarios());
        this.dadosContato = new DadosContatoDto(pessoaFisica.getDadosContato());
    }

    public PessoaFisica converte() {
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setNomeCompleto(this.nomeCompleto);
        pessoaFisica.setRegistro(this.registro);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d'T'HH:mm");
        pessoaFisica.setDataNascimento(LocalDate.parse(this.dataNascimento, formatter));

        pessoaFisica.setSexo(this.sexo);
        pessoaFisica.setSenha(this.senha);
        pessoaFisica.setImg_avatar(this.img_avatar);
        pessoaFisica.setImg_background(this.img_background);
        pessoaFisica.setIdUsuario(this.idUsuario);
        pessoaFisica.setNacionalidade(this.nacionalidade.converte());
        pessoaFisica.setEndereco(this.endereco.converte());
        pessoaFisica.setDadosBancarios(this.dadosBancarios.converte());
        pessoaFisica.setDadosContato(this.dadosContato.converte());
        return pessoaFisica;
    }
}
