package dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record ProdutoDTO(
        @NotBlank
        String nome,

        @NotBlank
        String categoria,

        @NotNull
        @DecimalMin("0.01")
        Double preco,

        @NotNull
        @Min(0)
        Integer quantidade_estoq,

        String descricao,

        @FutureOrPresent
        LocalDate dataValidade
) {

}
