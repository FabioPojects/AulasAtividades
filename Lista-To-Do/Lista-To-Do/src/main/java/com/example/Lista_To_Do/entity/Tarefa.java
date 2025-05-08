package com.example.Lista_To_Do.entity;

import jakarta.persistence.*;

@Entity
public class Tarefa {

    public Tarefa() {}

    public Tarefa(Long id,String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;


    // Getters & Setters

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
}
