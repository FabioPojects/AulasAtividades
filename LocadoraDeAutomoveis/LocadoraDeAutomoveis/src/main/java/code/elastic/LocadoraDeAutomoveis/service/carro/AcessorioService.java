package code.elastic.LocadoraDeAutomoveis.service.carro;

import code.elastic.LocadoraDeAutomoveis.model.carro.Acessorio;
import code.elastic.LocadoraDeAutomoveis.repository.carro.AcessorioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcessorioService {

    private final AcessorioRepository repository;

    public List<Acessorio> listarAcessorios(){
        return repository.findAll();
    }

    public Acessorio cadastrarAcessorio(Acessorio acessorio){
        return repository.save(acessorio);
    }

}
