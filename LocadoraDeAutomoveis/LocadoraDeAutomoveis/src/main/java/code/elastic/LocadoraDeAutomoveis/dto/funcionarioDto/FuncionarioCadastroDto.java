package code.elastic.LocadoraDeAutomoveis.dto.funcionarioDto;

import code.elastic.LocadoraDeAutomoveis.model.pessoa.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record FuncionarioCadastroDto(@NotBlank @CPF String cpf,@NotBlank String email,
                                     @NotBlank LocalDate dataNascimento, @NotNull Sexo sexo) {
}
