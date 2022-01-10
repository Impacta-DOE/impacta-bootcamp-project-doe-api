package br.com.impacta.doe.doe.web.pessoa.juridica;

import br.com.impacta.doe.doe.application.service.pessoa.juridica.PessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.IOException;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/pessoa/juridica")
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaService service;

    @PostMapping
    public PessoaJuridicaDto salva(@RequestBody PessoaJuridicaDto dto) throws IOException {
        return service.salva(dto);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PessoaJuridicaDto> atualiza(@PathVariable Long id,
                                                      @RequestBody PessoaJuridicaDto dto) throws IOException {
        return service.atualiza(id, dto);
    }

    @PutMapping(path = "/{id}/upload/imagem",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String upload(@PathVariable Long id,
                         @RequestBody MultipartFile img_avatar,
                         @RequestBody MultipartFile img_background) throws IOException {
        return service.uploadImagem(id, img_avatar, img_background);
    }
}
