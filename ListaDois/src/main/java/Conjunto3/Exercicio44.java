package Conjunto3;

import java.util.Scanner;

public class Exercicio44 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double soma = 0;
        int totalValores = 500;

        System.out.print("Digite quantos valores: ");
        int valores = scanner.nextInt();

        System.out.print("Digite " + valores + "valores para calcular a média aritmetica: ");

        for (int i = 1; i <= totalValores; i++) {
            System.out.print("Digite o valor " + i + ": ");
            double valor = scanner.nextDouble();
            soma += valor;
        }

        double media = soma / totalValores;

        System.out.println("A média dos valores fornecidos é: " + media);
        scanner.close();

    }
}
