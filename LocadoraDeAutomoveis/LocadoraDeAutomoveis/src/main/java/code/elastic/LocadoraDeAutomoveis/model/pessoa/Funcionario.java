package code.elastic.LocadoraDeAutomoveis.model.pessoa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Funcionario extends Pessoa {

    @Column(name = "matricula", unique = true)
    private String matricula;

    public Funcionario(String cpf, String email, LocalDate dataNascimento, Sexo sexo) {
        super(cpf, email, dataNascimento, sexo);
    }
}
