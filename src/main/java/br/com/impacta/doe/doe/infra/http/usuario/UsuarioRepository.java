package br.com.impacta.doe.doe.infra.http.usuario;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface UsuarioRepository {
    String salvaUsuario(String username, String senha) throws JsonProcessingException;

    String buscaUsernamePorIdDoUsuario(String id);
}
