package code.elastic.ListaTo_Do.service;

import code.elastic.ListaTo_Do.exception.TarefaNaoEncontradaException;
import code.elastic.ListaTo_Do.model.Tarefa;
import code.elastic.ListaTo_Do.model.dto.TarefaMapper;
import code.elastic.ListaTo_Do.model.dto.TarefaRequestDto;
import code.elastic.ListaTo_Do.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public List<Tarefa> listarTarefas(){
        return tarefaRepository.findAll();
    }

    public Tarefa adicionarTarefa(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public void deletarTarefaPorTitulo(String titulo) throws TarefaNaoEncontradaException {
        Tarefa tarefa = tarefaRepository.findByTitulo(titulo);
        if (tarefa != null) {
            tarefaRepository.delete(tarefa);
            return;
        }
        throw new TarefaNaoEncontradaException("Tarefa não encontrada");
    }


}
