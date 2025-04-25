package elastic.code.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("livro_eletronico")
public class Eletronico extends Livro{

    @Column(name = "tamanho")
    private Integer tamanho;

    public Eletronico() {
    }

    public Eletronico(String titulo, String autores, String editora, Float preco, Integer tamanho) {
        super(titulo, autores, editora, preco);
        this.tamanho = tamanho;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Eletronico{" +
                "tamanho=" + tamanho +
                '}';
    }
}
