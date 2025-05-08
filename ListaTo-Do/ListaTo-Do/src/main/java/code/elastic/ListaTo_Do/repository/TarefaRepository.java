package code.elastic.ListaTo_Do.repository;

import code.elastic.ListaTo_Do.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    Tarefa findByTitulo(String titulo);

}
