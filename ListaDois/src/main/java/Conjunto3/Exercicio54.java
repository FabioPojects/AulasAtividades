package Conjunto3;

import java.util.Scanner;

public class Exercicio54 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Escolha qua moeda deseja conveter ");
        System.out.println(" 1 - Real > Dolar ");
        System.out.println(" 2 - Dolar > Real ");


        System.out.print(" Digite (1/2): ");
        int escolha = scanner.nextInt();

        if (escolha == 1) {
            System.out.print(" Valor (Reais): ");
            double real = scanner.nextDouble();
            double realDolar = real / 5.86;
            System.out.printf(" R$" + real + " = $ %.2f", realDolar );
        } else if (escolha == 2) {
            System.out.print(" Valor (Dolar): ");
            double dolar = scanner.nextDouble();
            double dolarReal = dolar * 5.86;
            System.out.println(" $" + dolar + " = R$" + dolarReal);
        }


    }
}
