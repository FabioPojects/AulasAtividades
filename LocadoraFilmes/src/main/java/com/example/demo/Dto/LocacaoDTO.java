package com.example.demo.Dto;

import java.time.LocalDate;

public record LocacaoDTO(Long clienteId,
                         Long filmeId,
                         LocalDate dataLocacao,
                         LocalDate dataDevolucao,
                         Boolean devolvido) {
}
