package br.com.impacta.doe.doe.application.service.pessoa.fisica;

import br.com.impacta.doe.doe.web.pessoa.fisica.PessoaFisicaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PessoaFisicaService {
    PessoaFisicaDto salva(PessoaFisicaDto dto) throws IOException;

    ResponseEntity<PessoaFisicaDto> atualiza(Long id, PessoaFisicaDto dto) throws IOException;

    String uploadImagem(Long id, MultipartFile img_avatar, MultipartFile img_background) throws IOException;
}
