package br.com.Desafio_Locadora.dto;

import java.util.Date;

public record FinalizacaoAluguelDTO(
        Long motoristaId,
        Long carroId,
        Date dataEntrega,
        Date dataDevolucao,
        Double valorTotal
) {}