package code.elastic.LocadoraDeAutomoveis.repository.pessoa;

import code.elastic.LocadoraDeAutomoveis.model.pessoa.Motorista;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface MotoristaRepository extends JpaRepository<Motorista, UUID> {

    boolean existsByCpfOrEmail(String cpf,String email);

    boolean existsMotoristaByNumeroCNH(String numeroCNH);

    void deleteMotoristaByNumeroCNH(String numeroCNH);
}
