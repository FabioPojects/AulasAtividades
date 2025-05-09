package code.elastic.LocadoraDeAutomoveis.model.carro;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ModeloCarro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    private Fabricante fabricante;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
}
