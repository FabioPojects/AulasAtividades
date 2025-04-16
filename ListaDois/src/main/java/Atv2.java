import java.util.Scanner;

public class Atv2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o salário mínimo atualmente: ");
        int salarioMinimo = scanner.nextInt();

        System.out.print("Digite seu salário: ");
        int salario = scanner.nextInt();

        double qtdSalario = (double) salario / salarioMinimo;

        System.out.printf("Você ganha aproximadamente %.1f salários mínimos", qtdSalario);

        scanner.close();

    }
}
