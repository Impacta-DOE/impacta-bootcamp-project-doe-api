package br.com.impacta.doe.doe.application.domain.exception;

import br.com.impacta.doe.doe.application.domain.exception.usuario.UsernameJaExisteException;
import br.com.impacta.doe.doe.application.domain.exception.usuario.UsuarioNaoExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
    private ResponseEntity<Object> buildResponseEntity(ErroApiForm erroApi) {
        return new ResponseEntity<>(erroApi, erroApi.getStatus());
    }

    @ExceptionHandler(UsernameJaExisteException.class)
    protected ResponseEntity<Object> handleUsernameJaExisteException(UsernameJaExisteException ex) {
        ErroApiForm form = new ErroApiForm(HttpStatus.BAD_REQUEST, ex);
        return buildResponseEntity(form);
    }

    @ExceptionHandler(UsuarioNaoExisteException.class)
    protected ResponseEntity<Object> handleUsuarioNaoExisteException(UsuarioNaoExisteException ex) {
        ErroApiForm form = new ErroApiForm(HttpStatus.BAD_REQUEST, ex);
        return buildResponseEntity(form);
    }
}