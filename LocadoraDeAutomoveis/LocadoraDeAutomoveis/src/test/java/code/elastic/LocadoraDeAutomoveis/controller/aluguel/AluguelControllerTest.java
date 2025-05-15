package code.elastic.LocadoraDeAutomoveis.controller.aluguel;

import code.elastic.LocadoraDeAutomoveis.model.aluguel.Aluguel;
import code.elastic.LocadoraDeAutomoveis.service.aluguel.AluguelService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class AluguelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AluguelService aluguelService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCadastrarAluguelComSucesso(){
        Aluguel aluguel = new Aluguel();
    }

}