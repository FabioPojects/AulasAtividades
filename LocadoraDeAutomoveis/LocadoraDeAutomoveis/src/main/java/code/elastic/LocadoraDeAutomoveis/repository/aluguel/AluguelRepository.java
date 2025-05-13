package code.elastic.LocadoraDeAutomoveis.repository.aluguel;

import code.elastic.LocadoraDeAutomoveis.model.aluguel.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

    @Query("SELECT MAX(f.matricula) FROM Funcionario f")
    String findMaxMatricula();


}
