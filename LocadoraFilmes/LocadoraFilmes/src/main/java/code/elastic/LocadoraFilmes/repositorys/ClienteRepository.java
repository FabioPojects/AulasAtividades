package code.elastic.LocadoraFilmes.repositorys;

import code.elastic.LocadoraFilmes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
