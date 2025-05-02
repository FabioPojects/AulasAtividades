package code.elastic.LocadoraFilmes.repositorys;

import code.elastic.LocadoraFilmes.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
}
