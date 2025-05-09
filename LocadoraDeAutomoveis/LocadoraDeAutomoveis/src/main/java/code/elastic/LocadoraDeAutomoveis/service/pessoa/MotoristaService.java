package code.elastic.LocadoraDeAutomoveis.service.pessoa;
import code.elastic.LocadoraDeAutomoveis.dto.motoristaDto.MotoristaCadastroDto;
import code.elastic.LocadoraDeAutomoveis.dto.motoristaDto.MotoristaMapper;
import code.elastic.LocadoraDeAutomoveis.exception.MotoristaConflitoException;
import code.elastic.LocadoraDeAutomoveis.exception.MotoristaNaoEncontradoException;
import code.elastic.LocadoraDeAutomoveis.model.pessoa.Motorista;
import code.elastic.LocadoraDeAutomoveis.repository.pessoa.MotoristaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotoristaService {

    private MotoristaRepository motoristaRepository;

    public List<Motorista> listarMotoristas(){
        return motoristaRepository.findAll();
    }

    public Motorista cadastrarMotorista(MotoristaCadastroDto cadastroDto){
        if (motoristaRepository.existsByCpfOrEmail(cadastroDto.cpf(), cadastroDto.email())){
            throw new MotoristaConflitoException("CPF ou e-mail já cadastrado.");
        }
        return motoristaRepository.save(MotoristaMapper.toEntity(cadastroDto));
    }

    public void deletarMotoristaPelaCNH(String cnh){
        if (motoristaRepository.existsMotoristaByNumeroCNH(cnh)){
            motoristaRepository.deleteMotoristaByNumeroCNH(cnh);
            return;
        }
        throw new MotoristaNaoEncontradoException("CNH de motorista não encontrada.");
    }
}
