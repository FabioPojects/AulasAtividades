import java.util.Scanner;

public class Atv3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira a quatidade de homemns dentro de sua sala: ");
        int qtdHomem = scanner.nextInt();

        System.out.print("Insira a quatidade de mulheres dentro de sua sala: ");
        int qtdMulheres = scanner.nextInt();

        int totalEstudantes = qtdHomem + qtdMulheres;

        double porcentagemHomem = (qtdHomem / (double) totalEstudantes) * 100;
        double porcentagemMulher = (qtdMulheres / (double) totalEstudantes) * 100;

        System.out.println("Porcentagens de Homens " + porcentagemHomem + "%");
        System.out.println("Porcentagem de Mulheres " + porcentagemMulher + "%") ;

        scanner.close();

    }
}
