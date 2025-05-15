package code.elastic.LocadoraDeAutomoveis.dto.carro;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.List;

public record CarroResponseDto(@NotBlank String placa, String cor, BigDecimal valorDiaria,
                               ModeloCarroDto modelo, List<AcessorioCarroDto> acessorios) {
}
