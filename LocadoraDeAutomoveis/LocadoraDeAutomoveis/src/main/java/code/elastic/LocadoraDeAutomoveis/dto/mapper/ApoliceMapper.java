package code.elastic.LocadoraDeAutomoveis.dto.mapper;

import code.elastic.LocadoraDeAutomoveis.dto.aluguel.ApoliceRequestDto;
import code.elastic.LocadoraDeAutomoveis.dto.aluguel.ApoliceResponseDto;
import code.elastic.LocadoraDeAutomoveis.model.aluguel.ApoliceSeguro;

public class ApoliceMapper {

    public static ApoliceSeguro toEntity(ApoliceRequestDto dto){
        return new ApoliceSeguro(dto.protecaoTerceiro(), dto.protecaoCausasNaturais(), dto.protecaoRoubo());
    }

    public static ApoliceResponseDto toResponseDto(ApoliceSeguro entity){
        return new ApoliceResponseDto(entity.getValorFranquia(), entity.getProtecaoTerceiro(),
                entity.getProtecaoCausasNaturais(), entity.getProtecaoRoubo());
    }
}
