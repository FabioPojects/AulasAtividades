package br.com.Desafio_Locadora.dto;

import br.com.Desafio_Locadora.tipos.Sexo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record CadastrarPessoaDTO(
        @NotBlank String nome,
        @Past LocalDate dataNascimento,
        @Pattern(regexp = "\\d{11}") String cpf,
        @Enumerated(EnumType.STRING) Sexo sexo,
        @Email String email
) {
}
