package br.com.Desafio_Locadora.dto;

public record MotoristaDTO(
        Long id,
        String nome,
        String cpf,
        String email,
        String numeroCnh
) {}