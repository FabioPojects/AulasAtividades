package br.com.Desafio_Locadora.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AcessorioCarro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_acessorioCarro;

    @ManyToMany(
            mappedBy = "acessorioCarro"
    )
    List<Carros> carros;

    private String descricao;
}
