import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual a quantidade de homens na turma? ");
        Double homens = scanner.nextDouble();

        System.out.println("Qual a quantidade de mulheres na turma? ");
        Double mulheres = scanner.nextDouble();

        System.out.println("A turma possui %.0f %% de homens e %.0f %% de mulheres."
                .formatted((homens / (homens + mulheres) * 100),
        (mulheres / (homens + mulheres) * 100)));
    }
}
