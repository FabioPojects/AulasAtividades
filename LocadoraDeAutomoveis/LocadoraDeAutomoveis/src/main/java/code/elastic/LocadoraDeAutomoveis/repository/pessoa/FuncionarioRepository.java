package code.elastic.LocadoraDeAutomoveis.repository.pessoa;

import code.elastic.LocadoraDeAutomoveis.model.pessoa.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {

    @Query("SELECT MAX(f.matricula) FROM Funcionario f")
    String findMaxMatricula();

    boolean existsByCpfOrEmail(String cpf, String email);

    boolean existsByMatricula(String matricula);

    void deleteFuncionarioByMatricula(String matricula);
}
