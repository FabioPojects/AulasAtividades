package code.elastic.LocadoraDeAutomoveis.service.aluguel;

import code.elastic.LocadoraDeAutomoveis.dto.aluguel.AluguelMapper;
import code.elastic.LocadoraDeAutomoveis.dto.aluguel.AluguelRequestDto;
import code.elastic.LocadoraDeAutomoveis.exception.AluguelNaoEncontradorepository;
import code.elastic.LocadoraDeAutomoveis.exception.ApoliceNaoEncontradaException;
import code.elastic.LocadoraDeAutomoveis.exception.CarroNaoEncontradoException;
import code.elastic.LocadoraDeAutomoveis.exception.MotoristaNaoEncontradoException;
import code.elastic.LocadoraDeAutomoveis.model.aluguel.Aluguel;
import code.elastic.LocadoraDeAutomoveis.model.aluguel.ApoliceSeguro;
import code.elastic.LocadoraDeAutomoveis.model.carro.Carro;
import code.elastic.LocadoraDeAutomoveis.model.pessoa.Motorista;
import code.elastic.LocadoraDeAutomoveis.repository.aluguel.AluguelRepository;
import code.elastic.LocadoraDeAutomoveis.repository.aluguel.ApoliceSeguroRepository;
import code.elastic.LocadoraDeAutomoveis.repository.carro.CarroRepository;
import code.elastic.LocadoraDeAutomoveis.repository.pessoa.MotoristaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
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

    public Aluguel cadastrarAluguel(AluguelRequestDto dto){
        ApoliceSeguro apolice = apoliceRepository.findById(dto.apolice().id())
                .orElseThrow(() -> new ApoliceNaoEncontradaException("Id de Apolice não encontrada"));

        Motorista motorista = motoristaRepository.findById(dto.motorista().id())
                .orElseThrow(() -> new MotoristaNaoEncontradoException("ID de Motorista não encontrado"));

        Carro carro = carroRepository.findById(dto.carro().id())
                .orElseThrow(() -> new CarroNaoEncontradoException("ID de Carro não encontrado"));

        Aluguel aluguel = AluguelMapper.toEntity(dto, apolice, motorista, carro);
        Calendar dataPedido = Calendar.getInstance();
        aluguel.setDataPedido(dataPedido);

        long millisPedido = dataPedido.getTimeInMillis();
        long millisDevolucao = dto.dataDevolucao().getTime();
        long diffMillis = millisDevolucao - millisPedido;
        long dias = diffMillis / (1000 * 60 * 60 * 24);
        BigDecimal diasBigDecimal = BigDecimal.valueOf(dias);

        aluguel.setValorTotal(diasBigDecimal.multiply(carro.getValorDiaria()).add(apolice.getValorFranquia()));
        return aluguel;
    }

    public Void deletarAluguel(Long id){
        if (aluguelRepository.existsById(id)){
            aluguelRepository.existsById(id);
        }
        throw new AluguelNaoEncontradorepository("Aluguel com ID não encontrado");
    }

}
