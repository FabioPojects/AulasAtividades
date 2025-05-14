package br.com.Desafio_Locadora.entity;


import br.com.Desafio_Locadora.dto.CadastroMotoristaDTO;
import br.com.Desafio_Locadora.tipos.Sexo;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Motorista extends Pessoa {

    private String numeroCnh;

    public Motorista(CadastroMotoristaDTO dto) {
        super(dto.nome(),dto.dataNascimento(), dto.cpf(), Sexo.fromString(dto.sexo()), dto.email());
        this.numeroCnh = dto.numeroCnh();

    }
}
