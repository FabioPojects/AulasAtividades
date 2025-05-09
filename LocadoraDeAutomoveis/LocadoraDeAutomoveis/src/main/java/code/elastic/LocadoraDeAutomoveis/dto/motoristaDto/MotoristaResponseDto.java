package code.elastic.LocadoraDeAutomoveis.dto.motoristaDto;

import code.elastic.LocadoraDeAutomoveis.model.pessoa.Sexo;

import java.time.LocalDate;

public record MotoristaResponseDto(String cnh, String email, LocalDate dataNascimento, Sexo sexo) {
}
