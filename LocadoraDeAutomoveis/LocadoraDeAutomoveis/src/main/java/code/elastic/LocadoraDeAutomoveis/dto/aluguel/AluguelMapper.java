package code.elastic.LocadoraDeAutomoveis.dto.aluguel;

import code.elastic.LocadoraDeAutomoveis.model.aluguel.Aluguel;
import code.elastic.LocadoraDeAutomoveis.model.aluguel.ApoliceSeguro;
import code.elastic.LocadoraDeAutomoveis.model.carro.Carro;
import code.elastic.LocadoraDeAutomoveis.model.pessoa.Motorista;

public class AluguelMapper {

    public static Aluguel toEntity(AluguelRequestDto dto, ApoliceSeguro apolice, Motorista motorista, Carro carro){
        return new Aluguel(dto.dataDevolucao(), apolice, motorista, carro);
    }

    public static AluguelResponseDto toResponse(Aluguel entity){

    }

}
