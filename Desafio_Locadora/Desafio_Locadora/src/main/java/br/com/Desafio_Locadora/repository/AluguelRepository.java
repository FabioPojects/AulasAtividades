package br.com.Desafio_Locadora.repository;

import br.com.Desafio_Locadora.entity.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

}
