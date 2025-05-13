package code.elastic.LocadoraDeAutomoveis.model.aluguel;

import code.elastic.LocadoraDeAutomoveis.model.carro.Carro;
import code.elastic.LocadoraDeAutomoveis.model.pessoa.Motorista;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataPedido;

    private Date dataEntrega;

    private Date dataDevolucao;

    private BigDecimal valorTotal;

    @OneToOne
    private ApoliceSeguro apoliceSeguro;

    @ManyToOne
    private Motorista motorista;

    @ManyToOne
    private Carro carro;

    public Aluguel(Date dataDevolucao, ApoliceSeguro apoliceSeguro, Motorista motorista, Carro carro) {
        this.dataPedido = Calendar.getInstance();
        this.dataDevolucao = dataDevolucao;
        this.apoliceSeguro = apoliceSeguro;
        this.motorista = motorista;
        this.carro = carro;
    }
}
