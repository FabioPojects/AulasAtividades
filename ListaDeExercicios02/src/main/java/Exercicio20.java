import java.util.Scanner;

public class Exercicio20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nomes = new String[2];
        Integer[] idades = new Integer[2];

        System.out.println("Nome da primeira pessoa: ");
        nomes[0] = scanner.nextLine();
        System.out.println("Idade da primeira pessoa: ");
        idades[0] = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nome da segunda pessoa: ");
        nomes[1] = scanner.nextLine();
        System.out.println("Idade da segunda pessoa: ");
        idades[1] = scanner.nextInt();

        if (idades[0] >= idades[1]){
            System.out.println("Pessoa mais velha: %s \n Pessoa mais nova: %s".formatted(nomes[0], nomes[1]));
        }else {
            System.out.println("Pessoa mais velha: %s \n Pessoa mais nova: %s".formatted(nomes[1], nomes[0]));
        }
    }
}
