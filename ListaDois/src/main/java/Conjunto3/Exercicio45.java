package Conjunto3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();

        System.out.println("Digite 100 números:");

        for (int i = 0; i < 100; i++) {
            int numero = scanner.nextInt();
            numeros.add(numero);
        }

        int maior = numeros.getFirst();
        for (int numero : numeros) {
            if (numero > maior) {
                maior = numero;
            }
        }

        System.out.println("O maior número da lista é: " + maior);

        scanner.close();
    }
}
