package br.com.Desafio_Locadora.dto;

import java.time.LocalDate;

public record ListagemAluguelDTO(
        Long id,
        LocalDate dataInicio,
        LocalDate dataFim,
        Double valorTotal
) {}
