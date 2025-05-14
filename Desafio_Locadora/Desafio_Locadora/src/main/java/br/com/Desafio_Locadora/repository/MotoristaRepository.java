package br.com.Desafio_Locadora.repository;

import br.com.Desafio_Locadora.entity.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MotoristaRepository extends JpaRepository<Motorista, Long> {
    boolean existsByEmail(String email);

}
