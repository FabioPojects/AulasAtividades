package code.elastic.LocadoraDeAutomoveis.model.carro;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String placa;

    private String chassi;

    private String cor;

    private BigDecimal valorDiaria;

    @ManyToOne
    private ModeloCarro modeloCarro;

    @ManyToMany
    private List<Acessorio> acessorios;
}
