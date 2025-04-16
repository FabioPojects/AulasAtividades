package org.example;

import java.util.Random;
import java.util.Scanner;

public class Atv15 {
    public static void main(String[] args) {
        Random random = new Random();

        int contador = 0;
        double soma = 0;

        System.out.println("Gerando 50 números para realizar a média:");
        while (contador < 50) {
            int numero = random.nextInt(100) + 1;
            System.out.println("Número " + (contador + 1) + ": " + numero);

            soma += numero;
            contador++;
        }
        double media = soma / 50;

        System.out.println("A méida aritimédica dos 50 números é de " + media);
    }
}
