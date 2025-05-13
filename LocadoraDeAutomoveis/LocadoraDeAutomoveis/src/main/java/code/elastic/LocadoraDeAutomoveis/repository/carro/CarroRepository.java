package code.elastic.LocadoraDeAutomoveis.repository.carro;

import code.elastic.LocadoraDeAutomoveis.model.carro.Carro;
import code.elastic.LocadoraDeAutomoveis.model.carro.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    Optional<Carro> findByPlaca(String placa);

    List<Carro> findAllByModeloCarroCategoria(Categoria categoria);

    boolean existsByPlaca(String placa);

}
