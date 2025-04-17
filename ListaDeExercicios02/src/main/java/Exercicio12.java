import java.util.Scanner;

public class Exercicio12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double somaNotas = 0.0;

        System.out.println("Sua idade: ");
        somaNotas += scanner.nextDouble();

        Double media = somaNotas/ 3;
        if (media >= 7){
            System.out.println("Aprovado.");
        }else if(media < 7 && media >= 5){
            System.out.println("Recuperação");
        }else if (media < 5){
            System.out.println("Reprovado");
        }
    }
}
