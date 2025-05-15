package code.elastic.LocadoraDeAutomoveis.service.pessoa;

import code.elastic.LocadoraDeAutomoveis.exception.FuncionarioConflitoexception;
import code.elastic.LocadoraDeAutomoveis.exception.FuncionarioNaoEncontradoException;
import code.elastic.LocadoraDeAutomoveis.model.pessoa.Funcionario;
import code.elastic.LocadoraDeAutomoveis.repository.pessoa.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarFuncionarios(){
        return funcionarioRepository.findAll();
    }

    public Funcionario cadastrarFuncionario(Funcionario funcionario){
        if (funcionarioRepository.existsByCpfOrEmail(funcionario.getCpf(), funcionario.getEmail())){
            throw new FuncionarioConflitoexception("CPF ou e-mail já cadastrado.");
        }

        int matricula = (funcionarioRepository.findMaxMatricula() != null)
                ? Integer.parseInt(funcionarioRepository.findMaxMatricula()) + 1 : 1;
        String novaMatricula = String.valueOf(matricula);

        funcionario.setMatricula(novaMatricula);
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario buscarPorMatricula(String matricula){
        return funcionarioRepository.findFuncionarioByMatricula(matricula);
    }

    public void deletarFuncionarioPorMatricula(String matricula){
        if (funcionarioRepository.existsByMatricula(matricula)){
            funcionarioRepository.deleteFuncionarioByMatricula(matricula);
            return;
        }
        throw new FuncionarioNaoEncontradoException("Matricula de funcionário não encontrada.");
    }

}
