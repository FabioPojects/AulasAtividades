import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercicio28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i < 4; i++){
            System.out.println("Digite um numero: ");
            numeros.add(scanner.nextInt());
        }
        System.out.println("Em ordem crescente: " + numeros.stream().sorted().toList());
    }
}
