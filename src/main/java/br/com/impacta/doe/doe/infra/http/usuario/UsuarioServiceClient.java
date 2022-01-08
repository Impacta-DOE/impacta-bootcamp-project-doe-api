package br.com.impacta.doe.doe.infra.http.usuario;

import br.com.impacta.doe.doe.application.domain.exception.usuario.UsernameJaExisteException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class UsuarioServiceClient implements UsuarioRepository {

    @Value("${url.api.auth}")
    private String baseURL;

    @Override
    public String salvaUsuario(String username, String senha) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        UsuarioJSON usuarioJSON = new UsuarioJSON();
        usuarioJSON.setUsername(username);
        usuarioJSON.setSenha(senha);

        String usuarioJson = new ObjectMapper().writeValueAsString(usuarioJSON);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> httpEntity = new HttpEntity<>(usuarioJson, httpHeaders);

        try {
            ResponseEntity<UsuarioJSON> response = restTemplate.exchange(
                    this.baseURL + "/usuario", HttpMethod.POST,
                    httpEntity, UsuarioJSON.class
            );
            if (response.getBody() != null) return String.valueOf(response.getBody().getId());
        } catch (Exception e) {
            throw new UsernameJaExisteException();
        }
        return null;
    }
}
