import java.util.Scanner;

public class Exercicio13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double somaNotas = 0.0;
        Double recuperacao = 0.0;

        System.out.println("Sua média de notas: ");
        somaNotas += scanner.nextDouble();

        Double media = somaNotas/ 3;
        if (media >= 5){
            System.out.println("Aprovado.");
        }else if(media < 5){
            System.out.println("Recuperação");
            System.out.println("Nota de recuperação: ");
            recuperacao = scanner.nextDouble();
        }else if (media + recuperacao < 5){
            System.out.println("Reprovado");
        }
    }
}
