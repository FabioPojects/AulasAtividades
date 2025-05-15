package code.elastic.LocadoraDeAutomoveis.dto.aluguel;

import code.elastic.LocadoraDeAutomoveis.dto.carro.CarroResponseDto;
import code.elastic.LocadoraDeAutomoveis.dto.motoristaDto.MotoristaResponseDto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AluguelResponseDto(LocalDate dataPedido, LocalDate dataDevolucao, BigDecimal valorTotal,
                                 ApoliceResponseDto apolice, MotoristaResponseDto motorista, CarroResponseDto carro) {
}
