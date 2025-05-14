package br.com.Desafio_Locadora.dto;

public record ListagemCarroDTO(
        Long id,
        br.com.Desafio_Locadora.entity.ModeloCarro modelo,
        String placa
) {
}
