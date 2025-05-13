package code.elastic.LocadoraDeAutomoveis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ApoliceNaoEncontradaException extends RuntimeException {
    public ApoliceNaoEncontradaException(String message) {
    }
}
