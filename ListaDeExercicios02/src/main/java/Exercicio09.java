import java.util.Scanner;

public class Exercicio09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual a sua idade?");
        Integer idade = scanner.nextInt();

        if (idade >= 18){
            System.out.println("É maior de idade.");
        }else {
            System.out.println("É menor de idade.");
        }
    }
}
