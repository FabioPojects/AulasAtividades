package code.elastic.LocadoraDeAutomoveis.model.pessoa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Motorista extends Pessoa{

    @Column(name = "numeroCNH", unique = true)
    private String numeroCNH;

    public Motorista(String cpf, String email, String numeroCNH, LocalDate dataNascimento, Sexo sexo) {
        super(cpf, email, dataNascimento, sexo);
        this.numeroCNH = numeroCNH;
    }
}
