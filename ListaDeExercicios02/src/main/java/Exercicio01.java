import java.time.LocalDate;
import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Em que ano você nasceu? ");
        Integer anoNascimento = scanner.nextInt();
        Integer anoAtual = LocalDate.now().getYear();

        System.out.println("Sua idade atual é: " + (anoAtual - anoNascimento));
    }
}
