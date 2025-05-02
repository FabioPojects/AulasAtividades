package code.elastic.LocadoraFilmes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Filme filme;

    private LocalDate dataLocacao;

    private LocalDate datadevolucao;

    private boolean devolvido;

    public Locacao(Cliente cliente, Filme filme, LocalDate dataLocacao) {
        this.cliente = cliente;
        this.filme = filme;
        this.dataLocacao = dataLocacao;
        devolvido = false;
    }

    public void atualizarStatus(){
        devolvido = !devolvido;
    }

}
