package br.com.Desafio_Locadora.entity;


import br.com.Desafio_Locadora.tipos.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModeloCarro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_modeloCarro;

    private String descricao;

    @ManyToOne
    Fabricante fabricante;

    @Enumerated(EnumType.STRING)
    Categoria categoria;
}
