package code.elastic.ListaTo_Do.service;

import code.elastic.ListaTo_Do.exception.TarefaNaoEncontradaException;
import code.elastic.ListaTo_Do.model.Tarefa;
import code.elastic.ListaTo_Do.repository.TarefaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;

    @InjectMocks
    private TarefaService tarefaService;

    @Test
    void deveListarTarefasDoBanco(){
        //Given
        Tarefa tarefaParaCadastro = new Tarefa("Estudar", "Estudar Java");
        Tarefa tarefaParaCadastro2 = new Tarefa("Treinar", "Ir para academia");
        Tarefa tarefaParaCadastro3 = new Tarefa("Ler", "Ler Diário de um Banana");
        List<Tarefa> tarefas = List.of(tarefaParaCadastro, tarefaParaCadastro2, tarefaParaCadastro3);

        //When
        when(tarefaRepository.findAll()).thenReturn(tarefas);
        List<Tarefa> resposta = tarefaService.listarTarefas();

        //Then
        assertIterableEquals(tarefas, resposta);
        assertEquals(tarefas.size(), resposta.size());
    }

    @Test
    void deveAdicionarTarefaComSucesso(){
        //Given
        Tarefa tarefaParaCadastro = new Tarefa("Estudar", "Estudar Java");

        //When
        when(tarefaRepository.save(tarefaParaCadastro)).thenReturn(tarefaParaCadastro);
        Tarefa saved = tarefaService.adicionarTarefa(tarefaParaCadastro);

        //Then
        assertEquals(tarefaParaCadastro.getTitulo(), saved.getTitulo());
        verify(tarefaRepository, times(1)).save(tarefaParaCadastro);
    }

    @Test
    void deveDeletarTarefaComSucesso() throws TarefaNaoEncontradaException {
        //Given
        Tarefa tarefaParaDelecao = new Tarefa("Estudar", "Estudar Java");
        String titulo = "Estudar";

        //When
        when(tarefaRepository.findByTitulo(titulo)).thenReturn(tarefaParaDelecao);
        tarefaService.deletarTarefaPorTitulo(titulo);

        //Then
        verify(tarefaRepository, times(1)).delete(tarefaParaDelecao);
    }

    @Test
    void deveLancarExcessaoQuandotarefaNaoEncontrada() throws TarefaNaoEncontradaException {
        //Given

        //When

        //Then
        assertThrows(TarefaNaoEncontradaException.class,
                () -> tarefaService.deletarTarefaPorTitulo("Correr na praça"));

    }

}