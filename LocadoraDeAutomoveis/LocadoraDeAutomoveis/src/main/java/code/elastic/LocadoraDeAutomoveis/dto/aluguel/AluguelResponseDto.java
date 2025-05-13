package code.elastic.LocadoraDeAutomoveis.dto.aluguel;

import code.elastic.LocadoraDeAutomoveis.dto.carro.CarroAluguelDto;
import code.elastic.LocadoraDeAutomoveis.dto.motoristaDto.MotoristaAluguelDto;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public record AluguelResponseDto(Calendar dataPedido, Date dataDevolucao, BigDecimal valorTotal,
                                 ApoliceAluguelDto apolice, MotoristaAluguelDto motorista, CarroAluguelDto carro) {
}
