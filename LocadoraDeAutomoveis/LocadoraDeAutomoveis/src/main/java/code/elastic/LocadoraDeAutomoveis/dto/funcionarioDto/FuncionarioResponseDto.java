package code.elastic.LocadoraDeAutomoveis.dto.funcionarioDto;

import code.elastic.LocadoraDeAutomoveis.model.pessoa.Sexo;

import java.time.LocalDate;

public record FuncionarioResponseDto(String matricula, String email,
                                     LocalDate dataNascimento, Sexo sexo) {
}
