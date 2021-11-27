package br.com.impacta.doe.doe.web.pessoa;

import br.com.impacta.doe.doe.application.domain.pessoa.DadosContato;
import lombok.Data;

@Data
public class DadosContatoDto {
    private Long id;
    private String email;
    private String telefone;

    public DadosContatoDto() {
    }

    public DadosContatoDto(DadosContato dadosContato) {
        this.id = dadosContato.getId();
        this.email = dadosContato.getEmail();
        this.telefone = dadosContato.getTelefone();
    }

    public DadosContato converte() {
        DadosContato dadosContato = new DadosContato();
        dadosContato.setId(this.id);
        dadosContato.setEmail(this.email);
        dadosContato.setTelefone(this.telefone);
        return dadosContato;
    }
}
