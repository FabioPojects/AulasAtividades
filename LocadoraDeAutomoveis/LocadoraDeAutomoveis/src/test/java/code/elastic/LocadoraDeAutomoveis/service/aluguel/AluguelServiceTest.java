package code.elastic.LocadoraDeAutomoveis.service.aluguel;

import code.elastic.LocadoraDeAutomoveis.dto.aluguel.AluguelRequestDto;
import code.elastic.LocadoraDeAutomoveis.dto.aluguel.ApoliceAluguelDto;
import code.elastic.LocadoraDeAutomoveis.dto.carro.CarroAluguelDto;
import code.elastic.LocadoraDeAutomoveis.dto.motoristaDto.MotoristaAluguelDto;
import code.elastic.LocadoraDeAutomoveis.model.aluguel.Aluguel;
import code.elastic.LocadoraDeAutomoveis.model.aluguel.ApoliceSeguro;
import code.elastic.LocadoraDeAutomoveis.model.carro.*;
import code.elastic.LocadoraDeAutomoveis.model.pessoa.Motorista;
import code.elastic.LocadoraDeAutomoveis.model.pessoa.Sexo;
import code.elastic.LocadoraDeAutomoveis.repository.aluguel.AluguelRepository;
import code.elastic.LocadoraDeAutomoveis.repository.aluguel.ApoliceSeguroRepository;
import code.elastic.LocadoraDeAutomoveis.repository.carro.CarroRepository;
import code.elastic.LocadoraDeAutomoveis.repository.pessoa.MotoristaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AluguelServiceTest {

    @Mock
    private AluguelRepository aluguelRepository;
    @Mock
    private ApoliceSeguroRepository apoliceRepository;
    @Mock
    private MotoristaRepository motoristaRepository;
    @Mock
    private CarroRepository carroRepository;
    @InjectMocks
    private AluguelService aluguelService;


    @Test
    @DisplayName("Quando chamado com 1 aluguel deve retornar lista com aluguel")
    void quandoAcionadoComAlugueisDeveRetornarLista(){
        //Given
        ApoliceSeguro apoliceSeguro = new ApoliceSeguro(1L, BigDecimal.valueOf(5.0000), true, false, true);
        Motorista motorista = new Motorista(1L, "111", "fernando@gmail.com", LocalDate.of(2005, 10, 02), Sexo.MASCULINO, "1");
        Fabricante fabricante = new Fabricante(1L, "Yukio Japones");
        ModeloCarro modelo = new ModeloCarro(1L, "carro do ano", fabricante, Categoria.MINIVAN);
        Acessorio acessorio1 = new Acessorio(1L, "Aerofólio");
        Acessorio acessorio2 = new Acessorio(2L, "Caixa de Som");
        Acessorio acessorio3 = new Acessorio(3L, "Calota Foda");
        Carro carro = new Carro(1L, "FER123", "1", "prata", BigDecimal.valueOf(50), modelo, List.of(acessorio1, acessorio2, acessorio3));

        Aluguel aluguel = new Aluguel(1L, LocalDate.of(2025, 5, 14), LocalDate.of(2025, 5, 29),
                LocalDate.of(2025, 5, 27), BigDecimal.valueOf(5650), apoliceSeguro, motorista, carro, false);

        List<Aluguel> alugueis = List.of(aluguel);

        //When
        when(aluguelRepository.findAll()).thenReturn(alugueis);
        List<Aluguel> resposta = aluguelService.listarAlugueis();

        //Then
        assertEquals(resposta, alugueis);
        assertEquals(resposta.size(), alugueis.size());
        assertEquals(resposta.getFirst(), alugueis.getFirst());
    }

    @Test
    @DisplayName("Quando acionado deve cadastrar aluguel com sucesso")
    void quandoAcionadoDeveCadastrarAluguelComSucesso(){
        //Given
        ApoliceSeguro apoliceSeguro = new ApoliceSeguro(1L, BigDecimal.valueOf(5.0000), true, false, true);
        Motorista motorista = new Motorista(1L, "111", "fernando@gmail.com", LocalDate.of(2005, 10, 02), Sexo.MASCULINO, "1");
        Fabricante fabricante = new Fabricante(1L, "Yukio Japones");
        ModeloCarro modelo = new ModeloCarro(1L, "carro do ano", fabricante, Categoria.MINIVAN);
        Acessorio acessorio1 = new Acessorio(1L, "Aerofólio");
        Acessorio acessorio2 = new Acessorio(2L, "Caixa de Som");
        Acessorio acessorio3 = new Acessorio(3L, "Calota Foda");
        Carro carro = new Carro(1L, "FER123", "1", "prata", BigDecimal.valueOf(50), modelo, List.of(acessorio1, acessorio2, acessorio3));

        Aluguel aluguel = new Aluguel(1L, LocalDate.of(2025, 5, 14), LocalDate.of(2025, 5, 29),
                LocalDate.of(2025, 5, 27), BigDecimal.valueOf(5650), apoliceSeguro, motorista, carro, false);

        ApoliceAluguelDto apoliceDto = new ApoliceAluguelDto(apoliceSeguro.getId());
        CarroAluguelDto carroAluguelDto = new CarroAluguelDto(carro.getId());
        MotoristaAluguelDto motoristaDto = new MotoristaAluguelDto(modelo.getId());

        AluguelRequestDto aluguelDto = new AluguelRequestDto(LocalDate.of(2025, 5, 27), apoliceDto, carroAluguelDto, motoristaDto);

        //When
        when(apoliceRepository.findById(anyLong())).thenReturn(Optional.of(apoliceSeguro));
        when(motoristaRepository.findById(anyLong())).thenReturn(Optional.of(motorista));
        when(carroRepository.findById(anyLong())).thenReturn(Optional.of(carro));
        Aluguel resposta = aluguelService.cadastrarAluguel(aluguelDto);

        //Then
        assertEquals(aluguel.getApoliceSeguro(), resposta.getApoliceSeguro());
        assertEquals(aluguel.getMotorista(), resposta.getMotorista());
        assertEquals(aluguel.getCarro(), resposta.getCarro());
    }

    @Test
    @DisplayName("Deve setar carrinho do aluguel como true")
    void deveSetarCarrinhoDoAluguelComoTrue(){
        //Given
        ApoliceSeguro apoliceSeguro = new ApoliceSeguro(1L, BigDecimal.valueOf(5.0000), true, false, true);
        Motorista motorista = new Motorista(1L, "111", "fernando@gmail.com", LocalDate.of(2005, 10, 02), Sexo.MASCULINO, "1");
        Fabricante fabricante = new Fabricante(1L, "Yukio Japones");
        ModeloCarro modelo = new ModeloCarro(1L, "carro do ano", fabricante, Categoria.MINIVAN);
        Acessorio acessorio1 = new Acessorio(1L, "Aerofólio");
        Acessorio acessorio2 = new Acessorio(2L, "Caixa de Som");
        Acessorio acessorio3 = new Acessorio(3L, "Calota Foda");
        Carro carro = new Carro(1L, "FER123", "1", "prata", BigDecimal.valueOf(50), modelo, List.of(acessorio1, acessorio2, acessorio3));

        Aluguel resultadoEsperado = new Aluguel(1L, LocalDate.of(2025, 5, 14), LocalDate.of(2025, 5, 29),
                LocalDate.of(2025, 5, 27), BigDecimal.valueOf(5650), apoliceSeguro, motorista, carro, false);

        // When
        when(aluguelRepository.findById(anyLong())).thenReturn(Optional.of(resultadoEsperado));
        aluguelService.adicionarNoCarrinho(resultadoEsperado.getId());

        // Then
        ArgumentCaptor<Aluguel> captor = ArgumentCaptor.forClass(Aluguel.class);
        verify(aluguelRepository).save(captor.capture());

        Aluguel aluguelSalvo = captor.getValue();
        assertTrue(aluguelSalvo.getCarrinho());
    }

    @Test
    @DisplayName("Quando acionado deve deletar todos os alugueis que estão no carrinho do motorista")
    void deveDeletarTodosOsAlugueisNoCarrinhoDoMotorista(){
        //Given
        ApoliceSeguro apoliceSeguro = new ApoliceSeguro(1L, BigDecimal.valueOf(5.0000), true, false, true);
        Motorista motorista = new Motorista(1L, "111", "fernando@gmail.com", LocalDate.of(2005, 10, 02), Sexo.MASCULINO, "1");
        Fabricante fabricante = new Fabricante(1L, "Yukio Japones");
        ModeloCarro modelo = new ModeloCarro(1L, "carro do ano", fabricante, Categoria.MINIVAN);
        Acessorio acessorio1 = new Acessorio(1L, "Aerofólio");
        Acessorio acessorio2 = new Acessorio(2L, "Caixa de Som");
        Acessorio acessorio3 = new Acessorio(3L, "Calota Foda");
        Carro carro = new Carro(1L, "FER123", "1", "prata", BigDecimal.valueOf(50), modelo, List.of(acessorio1, acessorio2, acessorio3));

        Aluguel aluguel = new Aluguel(1L, LocalDate.of(2025, 5, 14), LocalDate.of(2025, 5, 29),
                LocalDate.of(2025, 5, 27), BigDecimal.valueOf(5650), apoliceSeguro, motorista, carro, false);

        List<Aluguel> alugueis = List.of(aluguel);

        // When
        when(aluguelRepository.findAllByMotorista_IdAndCarrinhoIsTrue(anyLong())).thenReturn(alugueis);
        aluguelService.cancelarCarrinho(motorista.getId());

        // Then
        verify(aluguelRepository, times(1)).deleteAll(alugueis);
    }

}