package code.elastic.LocadoraDeAutomoveis.model.aluguel;

import code.elastic.LocadoraDeAutomoveis.model.pessoa.Motorista;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private Calendar dataPedido;

    private Date dataEntrega;

    private Date dataDevolucao;

    private BigDecimal valorTotal;

    @ManyToOne
    private ApoliceSeguro apoliceSeguro;

    @ManyToOne
    private Motorista motorista;
}
