package org.example;

public class Atv8 {
        public static String verificaParOuImpar(int numero) {
            return (numero % 2 == 0) ? "Par" : "Ímpar";
        }

        public static void main(String[] args) {
            int numero1 = 7;
            int numero2 = 10;

            System.out.println(numero1 + " é " + verificaParOuImpar(numero1));
            System.out.println(numero2 + " é " + verificaParOuImpar(numero2));
        }
}
