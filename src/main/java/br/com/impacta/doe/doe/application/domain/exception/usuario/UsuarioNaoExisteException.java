package br.com.impacta.doe.doe.application.domain.exception.usuario;

public class UsuarioNaoExisteException extends RuntimeException {
    public UsuarioNaoExisteException() {
        super("Usuário não existe ou não está vinculado com pessoa");
    }
}
