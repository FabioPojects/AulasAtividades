package org.example;

public class Atv11 {
    public static void main(String[] args) {
        int codigo = 4;

        String produto;
        if (codigo == 1) {
            produto = "Parafuso";
        } else if (codigo == 2) {
            produto = "Porca";
        } else if (codigo == 3) {
            produto = "Prego";
        } else {
            produto = "Diversos";
        }

        System.out.println("O Produto é: " + produto);
    }
}
