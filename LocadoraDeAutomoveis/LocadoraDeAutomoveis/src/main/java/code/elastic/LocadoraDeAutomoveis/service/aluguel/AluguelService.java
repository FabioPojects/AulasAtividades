package code.elastic.LocadoraDeAutomoveis.service.aluguel;

import code.elastic.LocadoraDeAutomoveis.dto.mapper.AluguelMapper;
import code.elastic.LocadoraDeAutomoveis.dto.aluguel.AluguelRequestDto;
import code.elastic.LocadoraDeAutomoveis.exception.AluguelNaoEncontradoException;
import code.elastic.LocadoraDeAutomoveis.exception.ApoliceNaoEncontradaException;
import code.elastic.LocadoraDeAutomoveis.exception.CarroNaoEncontradoException;
import code.elastic.LocadoraDeAutomoveis.exception.MotoristaNaoEncontradoException;
import code.elastic.LocadoraDeAutomoveis.model.aluguel.Aluguel;
import code.elastic.LocadoraDeAutomoveis.model.aluguel.ApoliceSeguro;
import code.elastic.LocadoraDeAutomoveis.model.aluguel.Pagamento;
import code.elastic.LocadoraDeAutomoveis.model.carro.Carro;
import code.elastic.LocadoraDeAutomoveis.model.pessoa.Motorista;
import code.elastic.LocadoraDeAutomoveis.repository.aluguel.AluguelRepository;
import code.elastic.LocadoraDeAutomoveis.repository.aluguel.ApoliceSeguroRepository;
import code.elastic.LocadoraDeAutomoveis.repository.carro.CarroRepository;
import code.elastic.LocadoraDeAutomoveis.repository.pessoa.MotoristaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AluguelService {

    private final AluguelRepository aluguelRepository;
    private final ApoliceSeguroRepository apoliceRepository;
    private final MotoristaRepository motoristaRepository;
    private final CarroRepository carroRepository;

    public List<Aluguel> listarAlugueis(){
        return aluguelRepository.findAll();
    }

    public List<Aluguel> listarAlugueisDisponiveis(){
        return aluguelRepository.buscarAlugueisDisponiveis(LocalDate.now());
    }

    public Aluguel cadastrarAluguel(AluguelRequestDto dto){
        ApoliceSeguro apolice = apoliceRepository.findById(dto.apolice().id())
                .orElseThrow(() -> new ApoliceNaoEncontradaException("Id de Apolice não encontrada"));

        Motorista motorista = motoristaRepository.findById(dto.motorista().id())
                .orElseThrow(() -> new MotoristaNaoEncontradoException("ID de Motorista não encontrado"));

        Carro carro = carroRepository.findById(dto.carro().id())
                .orElseThrow(() -> new CarroNaoEncontradoException("ID de Carro não encontrado"));

        Aluguel aluguel = AluguelMapper.toEntity(dto, apolice, motorista, carro);

        LocalDate dataPedido = LocalDate.now();
        aluguel.setDataPedido(dataPedido);

        Period diferenca = Period.between(dataPedido, dto.dataDevolucao());

        // Obtém a diferença em dias
        int dias = diferenca.getDays();

        aluguel.setValorTotal(carro.getValorDiaria().multiply(BigDecimal.valueOf(dias)).add(apolice.getValorFranquia()));
        return aluguelRepository.save(aluguel);
    }

    public List<Aluguel> listarAluguelNoCarrinho(){
        return aluguelRepository.findAllByCarrinhoTrue();
    }

    public Aluguel buscarPorId(Long id){
        return aluguelRepository.findById(id)
                .orElseThrow(() -> new AluguelNaoEncontradoException("Aluguel não encontrado"));
    }

    public void adicionarNoCarrinho(Long id){
        Aluguel aluguel = buscarPorId(id);
        aluguel.setCarrinho(true);
        aluguelRepository.save(aluguel);
    }

    public void cancelarCarrinho(Long id){
        List<Aluguel> alugueis = aluguelRepository.findAllByMotorista_IdAndCarrinhoIsTrue(id);
        aluguelRepository.deleteAll(alugueis);
    }

    public List<Aluguel> confirmarAlugueisDoCarrinho(Long motoristaId, Pagamento pagamento) {
        List<Aluguel> alugueisNoCarrinho = aluguelRepository.findAllByMotorista_IdAndCarrinhoIsTrue(motoristaId);
        alugueisNoCarrinho.forEach(aluguel -> {
            aluguel.setCarrinho(false);
            aluguel.setFormaDePagamento(pagamento);
        });
        return aluguelRepository.saveAll(alugueisNoCarrinho);
    }

    public List<Aluguel> listarMeusAlugueis(Long id){
       return aluguelRepository.findAllByMotorista_IdAndDataEntregaAfterAndCarrinhoIsTrue(id, LocalDate.now());
    }

    public void deletarAluguel(Long id){
        if (aluguelRepository.existsById(id)){
            aluguelRepository.existsById(id);
        }
        throw new AluguelNaoEncontradoException("Aluguel com ID não encontrado");
    }

}
