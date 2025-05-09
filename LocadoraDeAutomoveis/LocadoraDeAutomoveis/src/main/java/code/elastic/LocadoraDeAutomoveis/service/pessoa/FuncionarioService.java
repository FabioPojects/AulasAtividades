package code.elastic.LocadoraDeAutomoveis.service.pessoa;

import code.elastic.LocadoraDeAutomoveis.dto.funcionarioDto.FuncionarioCadastroDto;
import code.elastic.LocadoraDeAutomoveis.dto.funcionarioDto.FuncionarioMapper;
import code.elastic.LocadoraDeAutomoveis.exception.FuncionarioConflitoexception;
import code.elastic.LocadoraDeAutomoveis.exception.FuncionarioNaoEncontradoException;
import code.elastic.LocadoraDeAutomoveis.model.pessoa.Funcionario;
import code.elastic.LocadoraDeAutomoveis.repository.pessoa.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarFuncionarios(){
        return funcionarioRepository.findAll();
    }

    public Funcionario cadastrarFuncionario(FuncionarioCadastroDto cadastroDto){
        if (funcionarioRepository.existsByCpfOrEmail(cadastroDto.cpf(), cadastroDto.email())){
            throw new FuncionarioConflitoexception("CPF ou e-mail já cadastrado.");
        }
        return funcionarioRepository.save(FuncionarioMapper.toEntity(cadastroDto));
    }

    public void deletarFuncionarioPorMatricula(String matricula){
        if (funcionarioRepository.existsByMatricula(matricula)){
            funcionarioRepository.deleteFuncionarioByMatricula(matricula);
            return;
        }
        throw new FuncionarioNaoEncontradoException("Matricula de funcionário não encontrada.");
    }

}
