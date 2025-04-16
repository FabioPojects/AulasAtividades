import java.util.Scanner;

public class Atv9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o raio: ");
        double raio = scanner.nextDouble();

        double pi = 3.14;
        double area = raio * raio * pi;

        System.out.println("A área é: " + area);
    }
}