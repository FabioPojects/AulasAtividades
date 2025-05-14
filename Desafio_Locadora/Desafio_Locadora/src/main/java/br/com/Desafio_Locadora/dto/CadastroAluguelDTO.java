package br.com.Desafio_Locadora.dto;

import java.time.LocalDate;

public record CadastroAluguelDTO(
        Long idCarro,
        Long idMotorista,
        LocalDate dataInicio,
        LocalDate dataFim
) {}
