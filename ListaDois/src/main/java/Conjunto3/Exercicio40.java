package Conjunto3;

import java.util.Scanner;

public class Exercicio40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantas pessoas fazem parte do grupo? ");
        int quantidadePessoas = scanner.nextInt();

        int [] idades = new int[quantidadePessoas];
        int somaIdades = 0, maiorIdade = Integer.MIN_VALUE, menorIdade = Integer.MAX_VALUE;
        int maioresDeIdade = 0;

        for (int i = 0; i < quantidadePessoas; i++) {
            System.out.print("Digite a idade da pessoa " + (i + 1) + ": ");
            int idade = scanner.nextInt();
            idades[i] = idade;

            somaIdades += idade;
            if (idade > maiorIdade) maiorIdade = idade;
            if (idade < menorIdade) menorIdade = idade;
            if (idade >= 18) maioresDeIdade++;
        }

        double mediaIdades = (double) somaIdades / quantidadePessoas;

        System.out.println("\nResultados:");
        System.out.println("Média das idades: " + mediaIdades);
        System.out.println("Maior idade: " + maiorIdade);
        System.out.println("Menor idade: " + menorIdade);
        System.out.println("Quantidade de pessoas maior de idade: " + maioresDeIdade);
    }
}