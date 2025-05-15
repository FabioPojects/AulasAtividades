package code.elastic.LocadoraDeAutomoveis.dto.motoristaDto;

import code.elastic.LocadoraDeAutomoveis.model.pessoa.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record MotoristaCadastroDto(@NotBlank @CPF String cpf, @NotBlank String email,
                                   @NotBlank String numeroCNH, @NotBlank LocalDate dataNascimento,
                                   @NotNull Sexo sexo) {
}
