package Conjunto3;

import java.util.Scanner;

public class Exercicio56 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do candidato 1:");
        String candidato1 = scanner.nextLine();
        System.out.println("Digite o nome do candidato 2:");
        String candidato2 = scanner.nextLine();
        System.out.println("Digite o nome do candidato 3:");
        String candidato3 = scanner.nextLine();

        int votosCandidato1 = 0, votosCandidato2 = 0, votosCandidato3 = 0, votosBranco = 0;
        int totalVotos = 0;

        while (true) {
            System.out.println("Digite o número do candidato (1, 2, 3) ou '0' para voto em branco. Digite '-1' para encerrar:");
            int voto = scanner.nextInt();

            if (voto == -1) {
                break;
            }

            totalVotos++;
            switch (voto) {
                case 1:
                    votosCandidato1++;
                    break;
                case 2:
                    votosCandidato2++;
                    break;
                case 3:
                    votosCandidato3++;
                    break;
                case 0:
                    votosBranco++;
                    break;
                default:
                    System.out.println("Voto inválido!");
                    totalVotos--;
            }
        }

        double percentualCandidato1 = (double) votosCandidato1 / totalVotos * 100;
        double percentualCandidato2 = (double) votosCandidato2 / totalVotos * 100;
        double percentualCandidato3 = (double) votosCandidato3 / totalVotos * 100;
        double percentualBranco = (double) votosBranco / totalVotos * 100;

        System.out.println(" Resultados da eleição: ");
        System.out.printf("%s: %d votos (%.2f%%)%n", candidato1, votosCandidato1, percentualCandidato1);
        System.out.printf("%s: %d votos (%.2f%%)%n", candidato2, votosCandidato2, percentualCandidato2);
        System.out.printf("%s: %d votos (%.2f%%)%n", candidato3, votosCandidato3, percentualCandidato3);
        System.out.printf("Votos em branco: %d (%.2f%%)%n", votosBranco, percentualBranco);

        if (votosCandidato1 > votosCandidato2 && votosCandidato1 > votosCandidato3) {
            System.out.printf("O vencedor é: %s%n", candidato1);
        } else if (votosCandidato2 > votosCandidato1 && votosCandidato2 > votosCandidato3) {
            System.out.printf("O vencedor é: %s%n", candidato2);
        } else if (votosCandidato3 > votosCandidato1 && votosCandidato3 > votosCandidato2) {
            System.out.printf("O vencedor é: %s%n", candidato3);
        } else {
            System.out.println("A eleição terminou empatada!");
        }

        scanner.close();
    }
}