import java.util.Scanner;

public class Atv4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira sua 1° nota: ");
        int nota1 = scanner.nextInt();

        System.out.print("Insira sua 2° nota: ");
        int nota2 = scanner.nextInt();

        System.out.print("Insira sua 3° nota: ");
        int nota3 = scanner.nextInt();

        System.out.print("Insira sua 4° nota: ");
        int nota4 = scanner.nextInt();

        double mediaAritmetica = (double) (nota1 + nota2 + nota3 + nota4) / 4;

        System.out.println("A média aritmética de suas notas é: " + mediaAritmetica);


    }
}
