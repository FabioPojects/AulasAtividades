package Conjunto3;

import java.util.Scanner;

public class Exercicio36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o primeiro número: ");
        int num1 = scanner.nextInt();

        System.out.print("Informe o segundo número: ");
        int num2 = scanner.nextInt();

        System.out.println("Números ímpares entre " + num1 + " e " + num2 + ":");

        for (int i = Math.min(num1, num2); i <= Math.max(num1, num2); i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
        scanner.close();
    }
}