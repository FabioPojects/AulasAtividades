package com.example.demo.TestService;

import com.example.demo.entity.Status;
import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task();
        task.setId(1L);
        task.setTitulo("Teste Unitário");
        task.setDescricao("Descrição do Teste");
        task.setStatus(Status.PENDENTE);
    }

    @Test
    void testCriacaoTarefa() {
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task novaTask = taskService.criarTask(task);

        assertNotNull(novaTask);
        assertEquals("Teste Unitário", novaTask.getTitulo());
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void testBuscarPorId() {
        when(taskRepository.findById(anyLong())).thenReturn(java.util.Optional.of(task));

        Task taskEncontrada = taskService.getTaskById(1L);

        assertNotNull(taskEncontrada);
        assertEquals(1L, taskEncontrada.getId());
        verify(taskRepository, times(1)).findById(1L);
    }

    @Test
    void testAtualizarTarefa() {
        when(taskRepository.findById(anyLong())).thenReturn(Optional.of(task));
        when(taskRepository.save(any(Task.class))).thenAnswer(invocation -> invocation.getArgument(0)); // Retorna a própria instância

        Task novaTask = new Task();
        novaTask.setTitulo("Atualizado");
        novaTask.setDescricao("Nova Descrição");
        novaTask.setStatus(Status.CONCLUIDA);

        Task taskAtualizada = taskService.updateTask(1L, novaTask);

        assertEquals("Atualizado", taskAtualizada.getTitulo());
        verify(taskRepository, times(1)).findById(1L);
        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    void testDeletarTarefa() {
        doNothing().when(taskRepository).deleteById(anyLong());

        assertDoesNotThrow(() -> taskService.deletarTarefa(1L));

        verify(taskRepository, times(1)).deleteById(1L);
    }
}

