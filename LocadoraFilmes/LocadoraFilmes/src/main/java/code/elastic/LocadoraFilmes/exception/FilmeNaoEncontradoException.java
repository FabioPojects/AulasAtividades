package code.elastic.LocadoraFilmes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class FilmeNaoEncontradoException extends RuntimeException {
    public FilmeNaoEncontradoException(String message) {
        super(message);
    }
}
