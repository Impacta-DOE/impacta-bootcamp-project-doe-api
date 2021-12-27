package br.com.impacta.doe.doe.web.pessoa.juridica;

import br.com.impacta.doe.doe.application.service.pessoa.juridica.PessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/pessoa/juridica")
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaService service;

    @PostMapping
    public PessoaJuridicaDto salva(@RequestBody PessoaJuridicaDto dto) throws IOException {
        return service.salva(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaJuridicaDto> atualiza(@PathVariable Long id,
                                                      @RequestBody PessoaJuridicaDto dto,
                                                      @RequestParam("img_avatar") MultipartFile img_avatar,
                                                      @RequestParam("img_background") MultipartFile img_background) throws IOException {
        return service.atualiza(id, dto, img_avatar, img_background);
    }
}
