package code.elastic.LocadoraDeAutomoveis.repository.carro;

import code.elastic.LocadoraDeAutomoveis.model.carro.Acessorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcessorioRepository extends JpaRepository<Acessorio, Long> {
}
