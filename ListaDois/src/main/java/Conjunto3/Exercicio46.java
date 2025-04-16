package Conjunto3;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio46 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> generos = new ArrayList<>();
        ArrayList<Integer> idades = new ArrayList<>();

        int homensMaioresDeIdade = 0;
        int mulheresMaioresDeIdade = 0;

        System.out.println("Digite o gênero (M para masculino, F para feminino) e a idade de 200 pessoas:");

        for (int i = 0; i < 200; i++) {
            System.out.print("Pessoa " + (i + 1) + " - Gênero: ");
            String genero = scanner.next();
            System.out.print("Pessoa " + (i + 1) + " - Idade: ");
            int idade = scanner.nextInt();

            generos.add(genero);
            idades.add(idade);
        }

        for (int i = 0; i < generos.size(); i++) {
            String genero = generos.get(i);
            int idade = idades.get(i);

            if (idade >= 18) {
                if (genero.equalsIgnoreCase("M")) {
                    homensMaioresDeIdade++;
                } else if (genero.equalsIgnoreCase("F")) {
                    mulheresMaioresDeIdade++;
                }
            }
        }

        System.out.println("Homens maiores de idade: " + homensMaioresDeIdade);
        System.out.println("Mulheres maiores de idade: " + mulheresMaioresDeIdade);

        scanner.close();
    }
}