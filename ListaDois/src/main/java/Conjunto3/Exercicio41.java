package Conjunto3;

import java.util.Scanner;

public class Exercicio41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroSorteado = (int) (Math.random() * 100) + 1;
        int tentativa;
        int numeroDeTentativas = 0;

        System.out.println("Bem-vindo ao jogo de adivinhação!");
        System.out.println("Tente adivinhar o número sorteado de 1 a 100.");

        do {
            System.out.print("Digite seu palpite: ");
            tentativa = scanner.nextInt();
            numeroDeTentativas++;

            if (tentativa < numeroSorteado) {
                System.out.println("O número sorteado é maior!");
            } else if (tentativa > numeroSorteado) {
                System.out.println("O número sorteado é menor!");
            }
        } while (tentativa != numeroSorteado);

        System.out.println("Parabéns! Você acertou o número!");
        System.out.println("Você levou " + numeroDeTentativas + " tentativa(s) para acertar.");
        scanner.close();
    }
}