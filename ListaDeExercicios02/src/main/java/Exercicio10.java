import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o seu salário bruto?");
        Double salarioBruto = scanner.nextDouble();
        System.out.println("Qual o seu dos descontos?");
        Double descontos = scanner.nextDouble();

        Double salarioLiquido = salarioBruto - descontos;

        Double emprestimo = salarioLiquido * 0.3;

        if (salarioLiquido > 1500){
            System.out.println("Você é elegivel para empréstimo!");
            System.out.println("Valor do empréstimo possível: " + emprestimo);
        }else {
            System.out.println("Você não é elegivel para empréstimo.");
        }
    }
}
