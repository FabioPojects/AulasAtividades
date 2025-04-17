import java.util.Scanner;

public class Exercicio27 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Primeiro numero: ");
        Double primeiroNum = scanner.nextDouble();
        System.out.println("Segundo numero: ");
        Double segundoNum = scanner.nextDouble();
        System.out.println("Primeiro numero: ");
        Double terceiroNum = scanner.nextDouble();

        if (primeiroNum > segundoNum && primeiroNum > terceiroNum){
            System.out.println("O primeiro numero é o maior.");
        }else if (segundoNum > primeiroNum && segundoNum > terceiroNum){
            System.out.println("O segundo numero é o maior.");
        }else if (terceiroNum > primeiroNum && terceiroNum > segundoNum){
            System.out.println("O terceiro numero é o maior.");
        }else if(primeiroNum == segundoNum) {
            System.out.println("O primeiro e o segundo numero são iguais.");
        }else if (primeiroNum == terceiroNum){
            System.out.println("O primeiro e o terceiro numero são iguais.");
        }else if (segundoNum == terceiroNum){
            System.out.println("O segundo e o terceiro numero sao iguas.");
        }else {
            System.out.println("Os 3 numeros são iguais.");
        }

    }
}
