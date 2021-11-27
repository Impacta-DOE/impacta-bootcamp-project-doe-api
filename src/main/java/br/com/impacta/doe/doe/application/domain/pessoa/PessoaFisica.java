package br.com.impacta.doe.doe.application.domain.pessoa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Data
@Entity
public class PessoaFisica extends Pessoa {
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String sexo;
    @OneToOne
    private Nacionalidade nacionalidade;
    private String registro;

    public PessoaFisica() {
    }
}
