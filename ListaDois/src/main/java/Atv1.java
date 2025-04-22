import java.time.LocalDate;
import java.util.Scanner;

public class Atv1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDate localDate  = LocalDate.now();

        int anoAtual = localDate.getYear();
        int mesAtual = localDate.getMonthValue();
        int diaAtual = localDate.getDayOfMonth();

        System.out.println("Hojê é " + diaAtual + "/" + mesAtual + "/" + anoAtual);

        System.out.print("Digite o Ano de nascimento: ");
        int anoNasc = scanner.nextInt();

        int idade = anoAtual - anoNasc;

        System.out.println("Você tem ou fará " + idade + " de idade");
        scanner.close();


    }
}
