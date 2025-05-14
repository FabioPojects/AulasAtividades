package br.com.Desafio_Locadora.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Carros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carros;

    private String placa;
    private String Chassi;
    private String cor;
    private BigDecimal valorDiaria;
    @Setter
    private Boolean reservado = false;

    @ManyToOne
    ModeloCarro modeloCarro;

    @ManyToMany
    @JoinTable(name = "carro_acessorio",
    joinColumns = @JoinColumn(name = "id_carros"), inverseJoinColumns = @JoinColumn(name = "id_acessorioCarro") )
    List<AcessorioCarro> acessorioCarro;

    public boolean isReservado() {
        return reservado;
    }

}
