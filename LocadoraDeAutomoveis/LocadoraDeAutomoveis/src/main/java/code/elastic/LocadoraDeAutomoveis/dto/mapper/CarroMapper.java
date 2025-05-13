package code.elastic.LocadoraDeAutomoveis.dto.mapper;

import code.elastic.LocadoraDeAutomoveis.dto.carro.AcessorioCarroDto;
import code.elastic.LocadoraDeAutomoveis.dto.carro.CarroRequestDto;
import code.elastic.LocadoraDeAutomoveis.dto.carro.CarroResponseDto;
import code.elastic.LocadoraDeAutomoveis.dto.carro.ModeloCarroDto;
import code.elastic.LocadoraDeAutomoveis.model.carro.Acessorio;
import code.elastic.LocadoraDeAutomoveis.model.carro.Carro;
import code.elastic.LocadoraDeAutomoveis.model.carro.Fabricante;
import code.elastic.LocadoraDeAutomoveis.model.carro.ModeloCarro;
import code.elastic.LocadoraDeAutomoveis.service.carro.CarroService;

import java.util.List;

public class CarroMapper {

    public static CarroResponseDto toResponse (Carro entity){
        ModeloCarro modelo = entity.getModeloCarro();
        ModeloCarroDto modeloDto = new ModeloCarroDto(modelo.getId());

        List<Acessorio> acessorios = entity.getAcessorios();
        List<AcessorioCarroDto> acessoriosDto = acessorios.stream().map(a ->
                new AcessorioCarroDto(a.getId())).toList();

        return new CarroResponseDto(entity.getPlaca(), entity.getCor(), entity.getValorDiaria(),
                modeloDto, acessoriosDto);
    }

    public static Carro toEntity(CarroRequestDto dto, ModeloCarro modelo, List<Acessorio> acessorios){
        return new Carro(dto.placa(), dto.chassi(), dto.cor(), dto.valorDiaria(),  modelo, acessorios);
    }

}
