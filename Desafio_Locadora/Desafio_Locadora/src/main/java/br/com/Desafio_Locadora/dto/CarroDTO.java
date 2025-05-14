package br.com.Desafio_Locadora.dto;

import br.com.Desafio_Locadora.entity.ModeloCarro;

public record CarroDTO(
        Long id,
        ModeloCarro modeloCarro,  // Adicione este atributo
        String placa,
        Boolean reservado
) { }