package br.com.Desafio_Locadora.repository;

import br.com.Desafio_Locadora.entity.Carros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carros, Long> {

}
