package br.com.impacta.doe.doe.web.pessoa;

import lombok.Data;

@Data
public class IdPessoaDto {
    private String idPessoa;

    public IdPessoaDto() {
    }

    public IdPessoaDto(Long idPessoa) {
        this.idPessoa = String.valueOf(idPessoa);
    }
}
