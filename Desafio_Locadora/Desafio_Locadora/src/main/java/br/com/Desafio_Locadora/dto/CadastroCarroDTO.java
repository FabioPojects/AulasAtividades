package br.com.Desafio_Locadora.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroCarroDTO(
        @NotBlank
        String modelo,

        @NotBlank
        String placa
) {
}
