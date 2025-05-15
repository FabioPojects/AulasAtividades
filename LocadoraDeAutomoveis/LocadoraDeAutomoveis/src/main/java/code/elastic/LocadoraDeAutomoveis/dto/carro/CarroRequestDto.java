package code.elastic.LocadoraDeAutomoveis.dto.carro;

import java.math.BigDecimal;
import java.util.List;

public record CarroRequestDto(String placa, String cor, BigDecimal valorDiaria, String chassi,
                              ModeloCarroDto idModelo, List<AcessorioCarroDto> idAcessorios) {
}
