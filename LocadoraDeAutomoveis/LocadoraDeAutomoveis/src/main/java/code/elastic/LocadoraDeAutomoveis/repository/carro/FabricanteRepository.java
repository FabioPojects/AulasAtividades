package code.elastic.LocadoraDeAutomoveis.repository.carro;

import code.elastic.LocadoraDeAutomoveis.model.carro.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
}
