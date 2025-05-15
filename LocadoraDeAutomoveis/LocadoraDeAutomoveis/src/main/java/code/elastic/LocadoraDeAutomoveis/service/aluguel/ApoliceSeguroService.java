package code.elastic.LocadoraDeAutomoveis.service.aluguel;

import code.elastic.LocadoraDeAutomoveis.dto.aluguel.ApoliceRequestDto;
import code.elastic.LocadoraDeAutomoveis.exception.ApoliceNaoEncontradaException;
import code.elastic.LocadoraDeAutomoveis.model.aluguel.ApoliceSeguro;
import code.elastic.LocadoraDeAutomoveis.repository.aluguel.ApoliceSeguroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApoliceSeguroService {
    private final ApoliceSeguroRepository repository;

    public List<ApoliceSeguro> listarApolices(){
        return repository.findAll();
    }

    public ApoliceSeguro salvarApolice(ApoliceSeguro apolice){
        BigDecimal valorFranquia = BigDecimal.ZERO;
        if (apolice.getProtecaoRoubo()) {
            valorFranquia = valorFranquia.add(BigDecimal.valueOf(3500.0));
        }
        if (apolice.getProtecaoCausasNaturais()){
            valorFranquia = valorFranquia.add(BigDecimal.valueOf(2000.0));
        }
        if (apolice.getProtecaoTerceiro()){
            valorFranquia = valorFranquia.add(BigDecimal.valueOf(1500.0));
        }
        apolice.setValorFranquia(valorFranquia);
        return repository.save(apolice);
    }

    public ApoliceSeguro atualizarSeguro(Long id, ApoliceSeguro apolice){
        if (repository.existsById(id)){
            apolice.setId(id);
            salvarApolice(apolice);
            return apolice;
        }
        throw new ApoliceNaoEncontradaException("Id de apolice não encontrado.");
    }

}
