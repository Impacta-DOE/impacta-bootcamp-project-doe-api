package br.com.impacta.doe.doe.application.service.pessoa;

import br.com.impacta.doe.doe.application.domain.pessoa.PessoaFisica;
import br.com.impacta.doe.doe.application.domain.pessoa.PessoaJuridica;
import br.com.impacta.doe.doe.infra.database.pessoa.PessoaFisicaRepository;
import br.com.impacta.doe.doe.infra.database.pessoa.PessoaJuridicoRepository;
import br.com.impacta.doe.doe.web.pessoa.IdPessoaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {
    private PessoaFisicaRepository fisicaRepository;
    private PessoaJuridicoRepository juridicoRepository;

    @Autowired
    public PessoaServiceImpl(PessoaFisicaRepository fisicaRepository, PessoaJuridicoRepository juridicoRepository) {
        this.fisicaRepository = fisicaRepository;
        this.juridicoRepository = juridicoRepository;
    }

    @Override
    public IdPessoaDto buscaPessoaPorUsuario(String id) {
        Optional<PessoaFisica> fisicaOptional = fisicaRepository.findByidUsuario(id);
        if (fisicaOptional.isPresent()) return new IdPessoaDto(fisicaOptional.get().getId());

        Optional<PessoaJuridica> juridicaOptional = juridicoRepository.findByidUsuario(id);
        if (juridicaOptional.isPresent()) return new IdPessoaDto(juridicaOptional.get().getId());

        throw new IllegalArgumentException("Usuário não existe ou não está vinculado com pessoa");
    }
}
