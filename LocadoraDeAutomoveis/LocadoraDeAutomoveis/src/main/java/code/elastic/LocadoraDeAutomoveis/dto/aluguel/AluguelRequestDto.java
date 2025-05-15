package code.elastic.LocadoraDeAutomoveis.dto.aluguel;

import code.elastic.LocadoraDeAutomoveis.dto.carro.CarroAluguelDto;
import code.elastic.LocadoraDeAutomoveis.dto.motoristaDto.MotoristaAluguelDto;

import java.time.LocalDate;
import java.util.Date;

public record AluguelRequestDto(LocalDate dataDevolucao, ApoliceAluguelDto apolice,
                                CarroAluguelDto carro, MotoristaAluguelDto motorista) {
}
