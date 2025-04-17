import java.util.Scanner;

public class Exercicio23 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] nomes = new String[3];
        Integer[] dias = new Integer[3];
        Integer[] meses = new Integer[3];
        nomes[0] = "janeiro";
        dias[0] = 1;
        meses[0] = 1;

        System.out.println("Nome da primeira pessoa: ");
        nomes[1] = scanner.nextLine();
        System.out.println("Idade da primeira pessoa: ");
        dias[1] = scanner.nextInt();
        System.out.println("Mês da primeira pessoa: ");
        meses[1] = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nome da segunda pessoa: ");
        nomes[2] = scanner.nextLine();
        System.out.println("Dia da segunda pessoa: ");
        dias[2] = scanner.nextInt();
        System.out.println("Mês da segunda pessoa: ");
        meses[2] = scanner.nextInt();

        if (meses[1] < meses[2]){
            System.out.println("%s Faz aniversário primeiro.".formatted(nomes[1]));
        }else if (meses[2] < meses[1]){
            System.out.println("%s faz aniversário primeiro.".formatted(nomes[2]));
        }else {
            if (dias[1] < dias[2]){
                System.out.println("%s Faz aniversário primeiro.".formatted(nomes[1]));
            }else if (meses[2] < meses[1]){
                System.out.println("%s faz aniversário primeiro.".formatted(nomes[2]));
            }else {
                System.out.println("Ambos fazem aniversário no mesmo dia!!");
            }
        }

    }
}
