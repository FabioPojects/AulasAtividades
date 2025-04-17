import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o valor inicial de débito? ");
        Double valorInicial = scanner.nextDouble();
        System.out.println("Quantos meses fazem? ");
        Integer meses = scanner.nextInt();
        System.out.println("Qual o valor dos juros mensais? ");
        Double juros = scanner.nextDouble();

        System.out.println("Valor final da divida: %.2f".formatted(valorInicial + ((valorInicial * juros) * meses)));
    }
}
