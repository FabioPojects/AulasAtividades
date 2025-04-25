package elastic.code.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("livro_impresso")
public class Impresso extends Livro{

    @Column(name = "frete")
    private Float frete;

    @Column(name = "estoque")
    private Integer estoque;

    public void atualizarEstoque(){
        this.estoque--;
    }

    @Override
    public String toString() {
        return "Impresso{" +
                "frete=" + frete +
                ", estoque=" + estoque +
                '}';
    }

    public Impresso() {
    }

    public Impresso(String titulo, String autores, String editora, Float preco, Integer estoque) {
        super(titulo, autores, editora, preco);
        this.estoque = estoque;
    }

    public Float getFrete() {
        return getPreco() * 0.10f;
    }

    public void setFrete(Float frete) {
        this.frete = frete;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }


}
