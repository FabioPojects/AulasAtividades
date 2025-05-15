package code.elastic.LocadoraDeAutomoveis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class FabricanteConflitoException extends RuntimeException {
    public FabricanteConflitoException(String message) {
    }
}
