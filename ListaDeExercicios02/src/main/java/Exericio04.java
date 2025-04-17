import java.util.Scanner;

public class Exericio04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double mediaNotas = 0.0;

        int i = 1;
        while (i < 5){
            System.out.println("Digite a sua %d nota: ".formatted(i));
            mediaNotas += scanner.nextDouble();
            i++;
        }
        System.out.println("Media aritmédica: " + mediaNotas / 4);
    }
}
