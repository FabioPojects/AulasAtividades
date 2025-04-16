import java.util.Scanner;

public class Atv4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de Milhas: ");
        int Milhas = scanner.nextInt();

        double ConversaoKm = Milhas * 1.6;

        System.out.println(Milhas + " Convertido para Quilômetro é: " + ConversaoKm + " Km");

        scanner.close();
    }
}
