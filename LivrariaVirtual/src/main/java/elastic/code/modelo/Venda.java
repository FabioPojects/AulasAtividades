package elastic.code.modelo;

import jakarta.persistence.*;
import org.hibernate.usertype.LoggableUserType;

import java.util.ArrayList;
import java.util.List;

    @Entity
    @DiscriminatorValue("venda_livro")
    public class Venda {

        @Id
        @Column(name = "numero")
        private Integer numero;

        @OneToMany
        private List<Livro> livros = new ArrayList<>();

        @Column(name = "numVendas")
        private Integer numVendas;

        @Column(name = "cliente")
        private String clientes;

        @Column(name = "valor")
        private Double valor;

        public void addLivro(Livro livro, Integer index) {
            this.livros.add(index, livro);
        }

        public Venda(List<Livro> livros, Integer numVendas, String clientes, Double valor) {
            this.livros = livros;
            this.numVendas = numVendas;
            this.clientes = clientes;
            this.valor = valor;
        }

        public List<Livro> listarLivro(){
            return livros;


        }
    }


