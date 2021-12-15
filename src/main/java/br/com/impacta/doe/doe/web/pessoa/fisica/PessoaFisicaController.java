package br.com.impacta.doe.doe.web.pessoa.fisica;

import br.com.impacta.doe.doe.application.service.pessoa.fisica.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/pessoa/fisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService service;

    @PostMapping
    public PessoaFisicaDto salva(@RequestBody PessoaFisicaDto dto) throws IOException {
        return service.salva(dto);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT, consumes = {"multipart/form-data"})
    public ResponseEntity<PessoaFisicaDto> atualiza(@PathVariable Long id,
                                                    @RequestBody PessoaFisicaDto dto,
                                                    @RequestParam("img_avatar") MultipartFile img_avatar,
                                                    @RequestParam("img_background") MultipartFile img_background) throws IOException {
        System.out.println(img_avatar.getOriginalFilename());
        System.out.println(img_background.getOriginalFilename());
        return service.atualiza(id, dto, img_avatar, img_background);
    }
}
