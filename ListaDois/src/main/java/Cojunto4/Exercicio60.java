package Cojunto4;

import java.util.Scanner;

public class Exercicio60 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor inicial da dívida: ");
        double divida = scanner.nextDouble();
        System.out.print("Digite a taxa de correção mensal (em %): ");
        double taxa = scanner.nextDouble() / 100;
        System.out.print("Digite a quantidade de anos: ");
        int anos = scanner.nextInt();

        System.out.println(" Evolução da dívida: ");
        System.out.printf("%-8s %-8s %-15s", "Ano", "Mês", "Valor da Dívida");
        System.out.println("--------------------------------------");

        for (int ano = 2007; ano < 2007 + anos; ano++) {
            for (int mes = 1; mes <= 12; mes++) {
                divida *= (1 + taxa);
                System.out.printf("%-8d %-8d R$ %.2f", ano, mes, divida);
            }
        }

        scanner.close();
    }
}