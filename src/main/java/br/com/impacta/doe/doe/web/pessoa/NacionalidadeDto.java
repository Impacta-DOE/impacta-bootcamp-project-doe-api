package br.com.impacta.doe.doe.web.pessoa;

import br.com.impacta.doe.doe.application.domain.pessoa.Nacionalidade;
import lombok.Data;

@Data
public class NacionalidadeDto {
    private Long id;
    private String descricao;

    public NacionalidadeDto() {
    }

    public NacionalidadeDto(Nacionalidade nacionalidade) {
        this.id = nacionalidade.getId();
        this.descricao = nacionalidade.getDescricao();
    }

    public Nacionalidade converte() {
        Nacionalidade nacionalidade = new Nacionalidade();
        nacionalidade.setId(id);
        nacionalidade.setDescricao(descricao);
        return nacionalidade;
    }
}
