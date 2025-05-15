package code.elastic.LocadoraDeAutomoveis.dto.aluguel;

import java.math.BigDecimal;

public record ApoliceResponseDto(BigDecimal valorFranquia, Boolean protecaoTerceiro,
                                 Boolean protecaoCausasNaturais, Boolean protecaoRoubo){
}
