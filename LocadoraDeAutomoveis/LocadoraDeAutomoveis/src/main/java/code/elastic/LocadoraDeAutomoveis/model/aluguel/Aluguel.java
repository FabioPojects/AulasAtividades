package code.elastic.LocadoraDeAutomoveis.model.aluguel;

import code.elastic.LocadoraDeAutomoveis.model.carro.Carro;
import code.elastic.LocadoraDeAutomoveis.model.pessoa.Motorista;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataPedido;

    private LocalDate dataEntrega;

    private LocalDate dataDevolucao;

    private BigDecimal valorTotal;

    @OneToOne
    private ApoliceSeguro apoliceSeguro;

    @ManyToOne
    private Motorista motorista;

    @ManyToOne
    private Carro carro;

    private Boolean carrinho;

    private Pagamento formaDePagamento;

    public Aluguel(LocalDate dataDevolucao, ApoliceSeguro apoliceSeguro, Motorista motorista, Carro carro) {
        this.dataDevolucao = dataDevolucao;
        this.apoliceSeguro = apoliceSeguro;
        this.motorista = motorista;
        this.carro = carro;
    }

    public Aluguel(Long id, LocalDate dataPedido, LocalDate dataEntrega, LocalDate dataDevolucao, BigDecimal valorTotal, ApoliceSeguro apoliceSeguro, Motorista motorista, Carro carro, Boolean carrinho) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.dataDevolucao = dataDevolucao;
        this.valorTotal = valorTotal;
        this.apoliceSeguro = apoliceSeguro;
        this.motorista = motorista;
        this.carro = carro;
        this.carrinho = carrinho;
    }
}
