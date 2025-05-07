package com.example.demo.TaskController;

import com.example.demo.controller.TaskController;
import com.example.demo.entity.Status;
import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private TaskService taskService;

    @Test
    void testCriarTarefa() throws Exception {
        Task task = new Task();
        task.setTitulo("Qualquer Coisa");
        task.setDescricao("Descrição de teste");
        task.setStatus(Status.PENDENTE);

        when(taskService.criarTask(any(Task.class))).thenReturn(task);

        mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.titulo").value("Qualquer Coisa"))
                .andExpect(jsonPath("$.descricao").value("Descrição de teste"));
    }

    @Test
    void testListarTarefas() throws Exception {
        when(taskService.getAllTasks()).thenReturn(List.of(new Task()));

        mockMvc.perform(get("/tasks"))
                .andDo(print()) // Debug
                .andExpect(status().isOk());
    }

    @Test
    void testBuscarPorId() throws Exception {
        Task task = new Task();
        task.setId(1L);
        task.setTitulo("Teste Buscar ID");
        task.setDescricao("Descrição teste");
        task.setStatus(Status.PENDENTE);

        when(taskService.getTaskById(1L)).thenReturn(task);

        mockMvc.perform(get("/tasks/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testAtualizarTarefa() throws Exception {
        Task taskAtualizada = new Task();
        taskAtualizada.setTitulo("Título Atualizado");
        taskAtualizada.setDescricao("Descrição do Teste");
        taskAtualizada.setStatus(Status.CONCLUIDA);

        mockMvc.perform(put("/tasks/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(taskAtualizada)))
                .andExpect(status().isOk());
    }

    @Test
    void deletarTarefa() throws Exception {
        mockMvc.perform(delete("/tasks/{id}", 1))
                .andExpect(status().isNoContent());
    }
}
