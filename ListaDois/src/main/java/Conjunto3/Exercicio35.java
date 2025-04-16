package Conjunto3;

import java.util.Random;
import java.util.Scanner;

public class Exercicio35 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantidade de números sorteados: ");
        int sorteado = scanner.nextInt();

        System.out.print("Escreva a primeira faixa do sorteio: ");
        int entrada = scanner.nextInt();

        System.out.print("Escreva a segunda faixa do sorteio: ");
        int saida = scanner.nextInt();

        int min = entrada;
        int max = saida;

        for (int i = 0; i < sorteado ; i++) {
            int numeroR = random.nextInt(max - min) + min;
            System.out.println(numeroR);

        }

    }
}
