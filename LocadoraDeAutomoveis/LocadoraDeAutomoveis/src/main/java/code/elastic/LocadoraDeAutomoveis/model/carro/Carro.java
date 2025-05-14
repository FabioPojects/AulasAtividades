package code.elastic.LocadoraDeAutomoveis.model.carro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;

    private String chassi;

    private String cor;

    private BigDecimal valorDiaria;

    @ManyToOne
    private ModeloCarro modeloCarro;

    @ManyToMany
    private List<Acessorio> acessorios;

    public Carro(String placa, String chassi, String cor, BigDecimal valorDiaria, ModeloCarro modeloCarro, List<Acessorio> acessorios) {
        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
        this.valorDiaria = valorDiaria;
        this.modeloCarro = modeloCarro;
        this.acessorios = acessorios;
    }

    public Carro(Long id, String placa, String chassi, String cor, BigDecimal valorDiaria, ModeloCarro modeloCarro, List<Acessorio> acessorios) {
        this.id = id;
        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
        this.valorDiaria = valorDiaria;
        this.modeloCarro = modeloCarro;
        this.acessorios = acessorios;
    }
}
