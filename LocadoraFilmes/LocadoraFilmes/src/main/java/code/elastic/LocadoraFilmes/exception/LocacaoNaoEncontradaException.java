package code.elastic.LocadoraFilmes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class LocacaoNaoEncontradaException extends RuntimeException {
    public LocacaoNaoEncontradaException(String message) {
        super(message);
    }
}
