package Conjunto3;

import java.util.Scanner;

public class Exercicio53 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite qual número gostaria de ver a tabuada: ");
        int numero = scanner.nextInt();

        System.out.println("Tabuada do " + numero + ": ");
        for (int i = 0; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }

        scanner.close();
    }
}
