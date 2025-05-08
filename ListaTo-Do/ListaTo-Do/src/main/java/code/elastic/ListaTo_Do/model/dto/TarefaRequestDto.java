package code.elastic.ListaTo_Do.model.dto;

import jakarta.validation.constraints.NotBlank;

public record TarefaRequestDto(@NotBlank String titulo, @NotBlank String descricao) {
}
