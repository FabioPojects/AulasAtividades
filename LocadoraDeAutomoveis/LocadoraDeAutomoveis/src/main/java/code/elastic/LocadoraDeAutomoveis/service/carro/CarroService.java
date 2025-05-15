package code.elastic.LocadoraDeAutomoveis.service.carro;

import code.elastic.LocadoraDeAutomoveis.dto.carro.CarroRequestDto;
import code.elastic.LocadoraDeAutomoveis.dto.mapper.CarroMapper;
import code.elastic.LocadoraDeAutomoveis.exception.*;
import code.elastic.LocadoraDeAutomoveis.model.carro.Acessorio;
import code.elastic.LocadoraDeAutomoveis.model.carro.Carro;
import code.elastic.LocadoraDeAutomoveis.model.carro.Categoria;
import code.elastic.LocadoraDeAutomoveis.model.carro.ModeloCarro;
import code.elastic.LocadoraDeAutomoveis.repository.carro.AcessorioRepository;
import code.elastic.LocadoraDeAutomoveis.repository.carro.CarroRepository;
import code.elastic.LocadoraDeAutomoveis.repository.carro.ModeloCarroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarroService {

    private final CarroRepository carroRepository;

    private final ModeloCarroRepository modeloRepository;

    private final AcessorioRepository acessorioRepository;

    public List<Carro> listarTodosCarros(){
        return carroRepository.findAll();
    }

    public List<Carro> listarCarrosDisponiveis(Categoria categoria){
        return carroRepository.findAllByModeloCarroCategoria(categoria);
    }

    public Carro cadastrarCarro(CarroRequestDto dto){
        ModeloCarro modeloCarro = modeloRepository.findById(dto.idModelo().id())
                .orElseThrow(() -> new ModeloDeCarronaoEncontrado("ID de modelo não existe."));

        List<Acessorio> acessorios = dto.idAcessorios().stream()
                .map(a -> acessorioRepository.findById(a.id())
                        .orElseThrow(() -> new AcessorioNaoEncontradoexception("ID de modelo não existe.")))
                .toList();

        Carro carro = CarroMapper.toEntity(dto, modeloCarro, acessorios);

        if (carroRepository.existsByPlaca(carro.getPlaca())){
          return carroRepository.save(carro);
        }
        throw new CarroConflitoException("Placa já cadastrada.");
    }

    public Carro encontrarCarroPorPlaca(String placa){
        Optional<Carro> carro = carroRepository.findByPlaca(placa);
        return carro.orElseThrow(()
                -> new CarroNaoEncontradoException("Placa de carro não encontrada."));
    }

    public void deletarCarroPorPlaca(String placa){
            Carro carro = encontrarCarroPorPlaca(placa);
            carroRepository.delete(carro);
    }

}
