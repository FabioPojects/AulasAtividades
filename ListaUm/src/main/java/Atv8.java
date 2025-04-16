import java.util.Scanner;

public class Atv8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String palavra = scanner.nextLine().toLowerCase();

        if (Palindromo(palavra)) {
            System.out.println("A palavra | " + palavra + " | é um palíndromo");
        } else {
            System.out.println("A palavra | " + palavra + " | Não é um palíndromo");
        }
        scanner.close();
    }

    public static boolean Palindromo(String palavra) {
        String invertida = new StringBuilder(palavra).reverse().toString();
        return palavra.equals(invertida);

    }
}
