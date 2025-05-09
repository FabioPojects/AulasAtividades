package code.elastic.LocadoraDeAutomoveis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MotoristaNaoEncontradoException extends RuntimeException {
    public MotoristaNaoEncontradoException(String message) {
    }
}
