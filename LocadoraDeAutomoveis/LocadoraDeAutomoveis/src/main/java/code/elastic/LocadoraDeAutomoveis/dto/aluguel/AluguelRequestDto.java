package code.elastic.LocadoraDeAutomoveis.dto.aluguel;

import code.elastic.LocadoraDeAutomoveis.dto.carro.CarroAluguelDto;
import code.elastic.LocadoraDeAutomoveis.dto.motoristaDto.MotoristaAluguelDto;

import java.util.Date;

public record AluguelRequestDto(Date dataDevolucao, ApoliceAluguelDto apolice,
                                CarroAluguelDto carro, MotoristaAluguelDto motorista) {
}
