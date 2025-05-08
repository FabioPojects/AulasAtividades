package com.example.Lista_To_Do.testCotroller;

import static org.mockito.ArgumentMatchers.any;

import com.example.Lista_To_Do.entity.Tarefa;
import com.example.Lista_To_Do.service.TarefaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ListaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private TarefaService tarefaService;

    @Test
    void listarTarefasTest() throws Exception {
        when(tarefaService.listarTarefas()).thenReturn(List.of(new Tarefa()));

        mockMvc.perform(get("/tarefas"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void adicionarTarefaTest() throws Exception {
        Tarefa tarefa = new Tarefa();
        tarefa.setNome("Criar uma lista de tarefas");

        when(tarefaService.salvarTarefa(any(String.class))).thenReturn(new Tarefa(1L, "Criar uma lista de tarefas"));

        mockMvc.perform(post("/tarefas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tarefa)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Criar uma lista de tarefas"));
    }

    @Test
    void deletarTarefaTest() throws Exception {
        mockMvc.perform(delete("/tarefas/{id}", 1))
                .andExpect(status().isOk());
    }
}
