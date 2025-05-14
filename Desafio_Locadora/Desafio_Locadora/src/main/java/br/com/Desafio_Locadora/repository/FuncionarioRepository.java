package br.com.Desafio_Locadora.repository;

import br.com.Desafio_Locadora.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
