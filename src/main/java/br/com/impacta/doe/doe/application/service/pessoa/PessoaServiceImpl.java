package br.com.impacta.doe.doe.application.service.pessoa;

import br.com.impacta.doe.doe.application.domain.exception.usuario.UsuarioNaoExisteException;
import br.com.impacta.doe.doe.application.domain.pessoa.PessoaFisica;
import br.com.impacta.doe.doe.application.domain.pessoa.PessoaJuridica;
import br.com.impacta.doe.doe.infra.database.pessoa.PessoaFisicaRepository;
import br.com.impacta.doe.doe.infra.database.pessoa.PessoaJuridicoRepository;
import br.com.impacta.doe.doe.infra.http.usuario.UsuarioRepository;
import br.com.impacta.doe.doe.web.pessoa.IdPessoaDto;
import br.com.impacta.doe.doe.web.pessoa.fisica.PessoaFisicaDto;
import br.com.impacta.doe.doe.web.pessoa.juridica.PessoaJuridicaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {
    private PessoaFisicaRepository fisicaRepository;
    private PessoaJuridicoRepository juridicoRepository;
    private UsuarioRepository usuarioRepository;

    @Autowired
    public PessoaServiceImpl(PessoaFisicaRepository fisicaRepository, PessoaJuridicoRepository juridicoRepository, UsuarioRepository usuarioRepository) {
        this.fisicaRepository = fisicaRepository;
        this.juridicoRepository = juridicoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public IdPessoaDto buscaIdDaPessoaPorUsuario(String id) {
        Optional<PessoaFisica> fisicaOptional = fisicaRepository.findByidUsuario(id);
        if (fisicaOptional.isPresent()) return new IdPessoaDto(fisicaOptional.get().getId());

        Optional<PessoaJuridica> juridicaOptional = juridicoRepository.findByidUsuario(id);
        if (juridicaOptional.isPresent()) return new IdPessoaDto(juridicaOptional.get().getId());

        throw new UsuarioNaoExisteException();
    }

    @Override
    public Object buscaPessoaPorUsuario(String id) {
        String username = usuarioRepository.buscaUsernamePorIdDoUsuario(id);

        Optional<PessoaFisica> fisicaOptional = fisicaRepository.findByidUsuario(id);
        if (fisicaOptional.isPresent()) return new PessoaFisicaDto(fisicaOptional.get(), username);

        System.out.println("pasou aqui 1");

        Optional<PessoaJuridica> juridicaOptional = juridicoRepository.findByidUsuario(id);
        if (juridicaOptional.isPresent()) return new PessoaJuridicaDto(juridicaOptional.get(), username);

        System.out.println("pasou aqui 2");

        throw new UsuarioNaoExisteException();
    }
}
