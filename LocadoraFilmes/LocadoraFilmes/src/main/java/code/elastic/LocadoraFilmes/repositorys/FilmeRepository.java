package code.elastic.LocadoraFilmes.repositorys;

import code.elastic.LocadoraFilmes.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
