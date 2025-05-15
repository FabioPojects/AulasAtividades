package code.elastic.LocadoraDeAutomoveis.repository.carro;

import code.elastic.LocadoraDeAutomoveis.model.carro.Categoria;
import code.elastic.LocadoraDeAutomoveis.model.carro.Fabricante;
import code.elastic.LocadoraDeAutomoveis.model.carro.ModeloCarro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, Long> {

    boolean existsByDescricaoAndFabricanteAndCategoria(String descricao, Fabricante fabricante, Categoria categoria);

}
