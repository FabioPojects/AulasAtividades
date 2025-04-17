import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Salario minimo atual: ");
        Double salarioMinimo = scanner.nextDouble();

        System.out.println("Seu salário: ");
        Double seuSalario = scanner.nextDouble();

        System.out.println("Você recebe: " + seuSalario/salarioMinimo + " salários minimos.");
    }
}
