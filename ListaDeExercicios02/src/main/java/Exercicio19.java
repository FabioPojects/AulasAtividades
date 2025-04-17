import java.util.Scanner;

public class Exercicio19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro numero: ");
        Double primeiroNum = scanner.nextDouble();
        System.out.println("Digite o segundo numero: ");
        Double segundoNum = scanner.nextDouble();

        if (primeiroNum < segundoNum){
            System.out.println(primeiroNum + segundoNum);
        }else {
            System.out.println(segundoNum + primeiroNum);
        }
    }
}
