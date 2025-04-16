package Conjunto3;

import java.util.Scanner;

public class Exercicio38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();

        if (numero <= 1){
            System.out.print(numero + "Não é um número primo.");
        } else {
            boolean isPrimo = true;

            for (int i = 2; i <= Math.sqrt(numero); i++) {
                if (numero % i == 0) {
                    isPrimo = false;
                    break;
                }
            }

            if (isPrimo) {
                System.out.println(numero + " é um número primo");
            } else {
                System.out.println(numero + " Não é um número primo");
            }
        }

        scanner.close();
    }
}
