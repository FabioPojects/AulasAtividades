package Conjunto3;

import java.util.Scanner;

public class Exercicio48 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira sua 1° nota: ");
        int nota1 = scanner.nextInt();

        System.out.print("Insira sua 2° nota: ");
        int nota2 = scanner.nextInt();

        System.out.print("Insira sua 3° nota: ");
        int nota3 = scanner.nextInt();

        System.out.print("Insira sua porcentagem de falta: ");
        int falta = scanner.nextInt();

        double media = (double) (nota1 + nota2 + nota3) / 3;

        if (media < 7 || falta >= 25) {
            System.out.println("Reprovado!!");
        } else {
            System.out.println("Aprovado!");
        }


    }
}
