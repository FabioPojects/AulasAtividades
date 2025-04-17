import java.util.Scanner;

public class Exercicio22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o dia e mês do primeiro aniversário: ");
        String primeiraData = scanner.nextLine();
        System.out.println("Digite o dia e mês do segundo aniversário: ");
        String segundaData = scanner.nextLine();

        primeiraData = primeiraData.replace("/", " ");
        segundaData = segundaData.replace("/", " ");

        if (primeiraData.equals(segundaData)){
            System.out.println("Datas iguais!!");
        }else {
            System.out.println("Não são iguais!!");
        }

    }
}
