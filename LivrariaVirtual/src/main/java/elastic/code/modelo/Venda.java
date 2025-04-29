package elastic.code.modelo;

import jakarta.persistence.*;
import org.hibernate.usertype.LoggableUserType;

import java.util.ArrayList;
import java.util.List;

    @Entity
    public class Venda {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "numero")
        private Integer numero;

        @ManyToMany
        private List<Livro> livros = new ArrayList<>();

        @Column(name = "cliente")
        private String clientes;

        @Column(name = "valor")
        private Float valor;

        public Venda() {
        }

        public void addLivro(Livro livro) {
            this.livros.add(livro);
        }

        public Venda(List<Livro> livros, String clientes, Float valor) {
            this.livros = livros;
            this.clientes = clientes;
            this.valor = valor;
        }

        public Integer getNumero() {
            return numero;
        }

        public void setNumero(Integer numero) {
            this.numero = numero;
        }

        public List<Livro> getLivros() {
            return livros;
        }

        public void setLivros(List<Livro> livros) {
            this.livros = livros;
        }

        public String getClientes() {
            return clientes;
        }

        public void setClientes(String clientes) {
            this.clientes = clientes;
        }

        public Float getValor() {
            return valor;
        }

        public void setValor(Float valor) {
            this.valor = valor;
        }
    }


