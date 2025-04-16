package Conjunto3;

import java.util.Scanner;

public class Exercicio51 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira quantos números quer a sequência: ");
        long qtd = scanner.nextLong();

        int a = 0;
        int b = 1;

        System.out.println(a);
        System.out.println(b);

        for (int i = 3; i <= qtd; i++) {
            int fib = a + b;
            System.out.println(fib);
            a = b;
            b = fib;
        }
    }
}