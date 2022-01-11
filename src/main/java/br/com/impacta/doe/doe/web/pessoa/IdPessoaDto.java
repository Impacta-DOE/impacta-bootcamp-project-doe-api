package br.com.impacta.doe.doe.web.pessoa;

import lombok.Data;

@Data
public class IdPessoaDto {
    private String idPessoa;
    private String tipoDaPessoa;

    public IdPessoaDto() {
    }

    public IdPessoaDto(Long idPessoa, String tipoDaPessoa) {
        this.idPessoa = String.valueOf(idPessoa);
        this.tipoDaPessoa = tipoDaPessoa;
    }
}
