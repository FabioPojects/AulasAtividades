package code.elastic.LocadoraFilmes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ClienteNaoEncontradoExcepetion extends RuntimeException {

    public ClienteNaoEncontradoExcepetion(String message) {
        super(message);
    }

    public ClienteNaoEncontradoExcepetion(String message, Throwable causa) {
        super(message, causa);
    }
}
