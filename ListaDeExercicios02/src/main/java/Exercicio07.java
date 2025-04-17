import java.util.Scanner;

public class Exercicio07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Despesa do cliente: ");
        Double despesaCliente = scanner.nextDouble();

        System.out.println("Comissão garçom: " + despesaCliente * 0.1);
    }
}
