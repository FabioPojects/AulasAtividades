package code.elastic.LocadoraDeAutomoveis.dto.mapper;

import code.elastic.LocadoraDeAutomoveis.dto.aluguel.AluguelRequestDto;
import code.elastic.LocadoraDeAutomoveis.dto.aluguel.AluguelResponseDto;
import code.elastic.LocadoraDeAutomoveis.dto.aluguel.ApoliceAluguelDto;
import code.elastic.LocadoraDeAutomoveis.dto.aluguel.ApoliceResponseDto;
import code.elastic.LocadoraDeAutomoveis.dto.carro.AcessorioCarroDto;
import code.elastic.LocadoraDeAutomoveis.dto.carro.CarroAluguelDto;
import code.elastic.LocadoraDeAutomoveis.dto.carro.CarroResponseDto;
import code.elastic.LocadoraDeAutomoveis.dto.carro.ModeloCarroDto;
import code.elastic.LocadoraDeAutomoveis.dto.motoristaDto.MotoristaAluguelDto;
import code.elastic.LocadoraDeAutomoveis.dto.motoristaDto.MotoristaResponseDto;
import code.elastic.LocadoraDeAutomoveis.model.aluguel.Aluguel;
import code.elastic.LocadoraDeAutomoveis.model.aluguel.ApoliceSeguro;
import code.elastic.LocadoraDeAutomoveis.model.carro.Acessorio;
import code.elastic.LocadoraDeAutomoveis.model.carro.Carro;
import code.elastic.LocadoraDeAutomoveis.model.carro.ModeloCarro;
import code.elastic.LocadoraDeAutomoveis.model.pessoa.Motorista;

import java.util.List;

public class AluguelMapper {

    public static Aluguel toEntity(AluguelRequestDto dto, ApoliceSeguro apoliceSeguro, Motorista motorista, Carro carro){
        return new Aluguel(dto.dataDevolucao(), apoliceSeguro, motorista, carro);
    }

    public static AluguelResponseDto toResponse(Aluguel entity){
        ModeloCarroDto modeloDto = new ModeloCarroDto(entity.getCarro().getModeloCarro().getId());

        List<Acessorio> acessorios = entity.getCarro().getAcessorios();
        List<AcessorioCarroDto> acessoriosDto = acessorios.stream().map(a ->
                new AcessorioCarroDto(a.getId())).toList();

        ApoliceResponseDto apolice = new ApoliceResponseDto(entity.getApoliceSeguro().getValorFranquia(), entity.getApoliceSeguro().getProtecaoTerceiro(),
                entity.getApoliceSeguro().getProtecaoCausasNaturais(), entity.getApoliceSeguro().getProtecaoRoubo());
        MotoristaResponseDto motorista = new MotoristaResponseDto(entity.getMotorista().getNumeroCNH(), entity.getMotorista().getEmail(),
                entity.getMotorista().getDataNascimento(), entity.getMotorista().getSexo());
        CarroResponseDto carro = new CarroResponseDto(entity.getCarro().getPlaca(), entity.getCarro().getCor(), entity.getCarro().getValorDiaria(),
                modeloDto, acessoriosDto);

        return new AluguelResponseDto(entity.getDataPedido(), entity.getDataDevolucao(), entity.getValorTotal(),
                apolice, motorista, carro);
    }

}
