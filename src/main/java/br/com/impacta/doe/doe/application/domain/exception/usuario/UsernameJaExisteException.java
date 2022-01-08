package br.com.impacta.doe.doe.application.domain.exception.usuario;

public class UsernameJaExisteException extends RuntimeException {
    public UsernameJaExisteException() {
        super("Usuário já existe");
    }
}
