package code.elastic.LocadoraDeAutomoveis.service.carro;

import code.elastic.LocadoraDeAutomoveis.exception.FabricanteConflitoException;
import code.elastic.LocadoraDeAutomoveis.exception.FabricanteNaoEncontradoException;
import code.elastic.LocadoraDeAutomoveis.model.carro.Fabricante;
import code.elastic.LocadoraDeAutomoveis.repository.carro.FabricanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FabricanteService {

    private final FabricanteRepository fabricanteRepository;

    public List<Fabricante> listarFabricantes(){
        return fabricanteRepository.findAll();
    }

    public Fabricante cadastrarFabricante(Fabricante fabricante){
        if (fabricanteRepository.existsByNome(fabricante.getNome())){
            return fabricanteRepository.save(fabricante);
        }
        throw new FabricanteConflitoException("Fabricante com esse nome já cadastrado.");
    }

    public Fabricante buscarPorNome(String nome){
     Fabricante fabricante = fabricanteRepository.findByNome(nome);
     if (fabricante != null){
         return fabricante;
     }
     throw new FabricanteNaoEncontradoException("Nome de Fabricante não encontrado.");
    }

    public void deletarFabricantePorId(Long id){
        if (fabricanteRepository.existsById(id)){
            fabricanteRepository.deleteById(id);
        }
        throw new FabricanteNaoEncontradoException("Nome de Fabricante não encontrado.");
    }

}
