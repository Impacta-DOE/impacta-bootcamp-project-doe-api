package br.com.impacta.doe.doe.web.pessoa;

import br.com.impacta.doe.doe.application.domain.pessoa.DadosBancarios;
import lombok.Data;

@Data
public class DadosBancariosDto {
    private Long id;
    private String banco;
    private String agencia;
    private String conta;
    private String codigoBanco;

    public DadosBancariosDto() {
    }

    public DadosBancariosDto(DadosBancarios dadosBancarios) {
        this.id = dadosBancarios.getId();
        this.agencia = dadosBancarios.getAgencia();
        this.banco = dadosBancarios.getBanco();
        this.codigoBanco = dadosBancarios.getCodigoBanco();
        this.conta = dadosBancarios.getConta();
    }

    public DadosBancarios converte() {
        DadosBancarios dadosBancarios = new DadosBancarios();
        dadosBancarios.setBanco(this.banco);
        dadosBancarios.setCodigoBanco(this.codigoBanco);
        dadosBancarios.setConta(this.conta);
        dadosBancarios.setAgencia(this.agencia);
        dadosBancarios.setId(this.id);
        return dadosBancarios;
    }
}
