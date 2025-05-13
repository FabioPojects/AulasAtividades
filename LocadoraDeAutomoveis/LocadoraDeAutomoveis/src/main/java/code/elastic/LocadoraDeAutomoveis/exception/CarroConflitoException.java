package code.elastic.LocadoraDeAutomoveis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class CarroConflitoException extends RuntimeException {
    public CarroConflitoException(String message) {
    }
}
