import java.util.Scanner;

public class Exercicio11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sua idade: ");
        Integer idade = scanner.nextInt();

        if (idade < 16){
            System.out.println("Não pode votar.");
        }else if(idade <= 18 || idade >= 65){
            System.out.println("Voto facultativo.");
        }else {
            System.out.println("Deve votar!");
        }
    }
}
