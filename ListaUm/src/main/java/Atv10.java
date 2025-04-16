import java.util.Scanner;

public class Atv10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma frase: ");
        String input = scanner.nextLine();

        int vogais = 0;
        int espacos = 0;
        int consoantes = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if ("aeiou".indexOf(c) != -1) {
                vogais++;
            } else if (c == ' ') {
                espacos++;
            } else if (c >= 'a' && c <= 'z') {
                consoantes++;
            }
        }

        System.out.println("Quantidade de vogais | " + vogais);
        System.out.println("Quantidade de espaços em branco | " + espacos);
        System.out.println("Quantidade de consoantes | " + consoantes);
    }
}
