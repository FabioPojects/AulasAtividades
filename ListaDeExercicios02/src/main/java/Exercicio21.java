import java.util.Scanner;

public class Exercicio21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o seu cargo?");
        String cargo = scanner.nextLine();
        System.out.println("Qual o seu salário?");
        Double salario = scanner.nextDouble();

        if (cargo.equalsIgnoreCase("diretoria")){
            System.out.println("Valor do empréstimo possível: %.2f".formatted(salario * 0.3));
        }else if(cargo.equalsIgnoreCase("gerencia")){
            System.out.println("Valor do empréstimo possível: %.2f".formatted(salario * 0.25));
        }else {
            System.out.println("Valor do empréstimo possível: %.2f".formatted(salario * 0.2));
        }

    }
}
