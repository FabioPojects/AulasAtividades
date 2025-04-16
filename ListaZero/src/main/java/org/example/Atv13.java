package org.example;

public class Atv13 {
    public static void main(String[] args) {
        for (int dado1 = 1; dado1 <= 6; dado1++) {
            for (int dado2 = 1; dado2 <= 6; dado2++) {
                    if (dado1 + dado2 == 7) {
                        System.out.println("Dado1: " + dado1 + "   Dado2: " + dado2);
                    }
            }
        }
    }
}
