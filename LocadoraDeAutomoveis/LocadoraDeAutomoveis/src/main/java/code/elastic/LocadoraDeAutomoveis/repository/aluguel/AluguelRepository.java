package code.elastic.LocadoraDeAutomoveis.repository.aluguel;

import code.elastic.LocadoraDeAutomoveis.model.aluguel.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

    @Query("SELECT MAX(f.matricula) FROM Funcionario f")
    String findMaxMatricula();

    List<Aluguel> findAllByCarrinhoTrue();

    List<Aluguel> findAllByMotorista_IdAndCarrinhoIsFalse(Long id);

    List<Aluguel> findAllByMotorista_IdAndCarrinhoIsTrue(Long id);

    List<Aluguel> findAllByMotorista_IdAndDataEntregaAfterAndCarrinhoIsTrue(Long motoristaId, LocalDate dataEntregaAfter);

    @Query("SELECT a FROM Aluguel a WHERE a.dataEntrega <= :data AND a.carrinho = false")
    List<Aluguel> buscarAlugueisDisponiveis(@Param("data") LocalDate data);

}
