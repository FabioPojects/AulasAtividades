package code.elastic.LocadoraDeAutomoveis.service.carro;

import code.elastic.LocadoraDeAutomoveis.exception.ModeloCarroConflitoException;
import code.elastic.LocadoraDeAutomoveis.exception.ModeloDeCarronaoEncontrado;
import code.elastic.LocadoraDeAutomoveis.model.carro.ModeloCarro;
import code.elastic.LocadoraDeAutomoveis.repository.carro.ModeloCarroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModeloCarroService {

    private final ModeloCarroRepository repository;

    public List<ModeloCarro> listarModelosDeCarro(){
        return repository.findAll();
    }

    public ModeloCarro cadastrarModeloDeCarro(ModeloCarro modelo){
        if (repository.existsByDescricaoAndFabricanteAndCategoria
                (modelo.getDescricao(), modelo.getFabricante(), modelo.getCategoria())){
            throw new ModeloCarroConflitoException("Modelo de Carro já cadastrado.");
        }
        return repository.save(modelo);
    }

    public void deletarModeloPorId(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return;
        }
        throw new ModeloDeCarronaoEncontrado("Modelo de Carro não encontrado");
    }

}
