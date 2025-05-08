package code.elastic.ListaTo_Do.controller;

import code.elastic.ListaTo_Do.model.Tarefa;
import code.elastic.ListaTo_Do.model.dto.TarefaMapper;
import code.elastic.ListaTo_Do.model.dto.TarefaRequestDto;
import code.elastic.ListaTo_Do.service.TarefaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class TarefaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TarefaService tarefaService;


    @Test
    void deveListarTarefaComSucesso() throws Exception {
        Tarefa tarefaParaCadastro = new Tarefa("Estudar", "Estudar Java");
        Tarefa tarefaParaCadastro2 = new Tarefa("Treinar", "Ir para academia");
        Tarefa tarefaParaCadastro3 = new Tarefa("Ler", "Ler Diário de um Banana");
        tarefaService.adicionarTarefa(tarefaParaCadastro);
        tarefaService.adicionarTarefa(tarefaParaCadastro2);
        tarefaService.adicionarTarefa(tarefaParaCadastro3);

        mockMvc.perform(get("/tarefas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }

    @Test
    void deveRetornarNoContentParaNenhumaTarefa() throws Exception {
        mockMvc.perform(get("/tarefas"))
                .andExpect(status().isNoContent())
                .andExpect(content().string(""));
    }

    @Test
    void deveInserirTarefaComSucesso() throws Exception {
        TarefaRequestDto tarefaParaCadastro = new TarefaRequestDto("Estudar", "Estudar Java");

        mockMvc.perform(post("/tarefas").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(tarefaParaCadastro)))
                .andExpect(status().isCreated());
    }

    @Test
    void deveDeletarComSucesso() throws Exception {
        Tarefa tarefaParaCadastro = new Tarefa("Estudar", "Estudar Java");
        String titulo = "Estudar";
        tarefaService.adicionarTarefa(tarefaParaCadastro);

        mockMvc.perform(delete("/tarefas/deletarTarefa?titulo={titulo}", titulo))
                .andExpect(status().isOk())
                .andExpect(content().string("Tarefa removida: %s".formatted(titulo)));
    }

}