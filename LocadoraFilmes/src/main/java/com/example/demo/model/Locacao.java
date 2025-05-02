package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Optional;

@Entity
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "filme_id", nullable = false)
    private Filme filme;

    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
    private Boolean devolvido;



    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Cliente getCliente() {return cliente;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}

    public Filme getFilme() {return filme;}
    public void setFilme(Filme filme) {this.filme = filme;}

    public LocalDate getDataLocacao() {return dataLocacao;}
    public void setDataLocacao(LocalDate dataLocacao) {this.dataLocacao = dataLocacao;}

    public LocalDate getDataDevolucao() {return dataDevolucao;}
    public void setDataDevolucao(LocalDate dataDevolucao) {this.dataDevolucao = dataDevolucao;}

    public Boolean getDevolvido() {return devolvido;}
    public void setDevolvido(Boolean devolvido) {this.devolvido = devolvido;}
}
