import java.util.Scanner;

public class Atv11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a primeira palavra: ");
        String palavra1 = scanner.nextLine();
        System.out.print("Digite a segunda palavra: ");
        String palavra2 = scanner.nextLine();

        if (palavra1.compareTo(palavra2) > 0) {
            System.out.println("Ordem Alfabética: " + palavra2 + ", " + palavra1);
        } else {
            System.out.println("Ordem Alfabética: " + palavra1 + ", " + palavra2);
        }

        if (palavra1.length() > palavra2.length()) {
            System.out.println("A palavra com mais caraceres é: " + palavra1);
        } else if (palavra2.length() > palavra1.length()) {
            System.out.println("A palavra com mais carateres é: " + palavra2);
        } else {
            System.out.println("As palavras têm o mesmo número de caracteres");
        }

        scanner.close();
    }
}
