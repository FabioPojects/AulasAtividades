package code.elastic.ListaTo_Do.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class TarefaNaoEncontradaException extends Throwable {
    public TarefaNaoEncontradaException(String tarefaNãoEncontrada) {
    }
}
