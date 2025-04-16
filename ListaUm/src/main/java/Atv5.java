import javax.swing.*;
import java.util.Scanner;

public class Atv5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dias = {"Segunda-Feira",
                        "Terça-Feira",
                        "Quarta-Feira",
                        "Quinta-Feira",
                        "Sexa-Feira",
                        "Sábado",
                        "Domingo"};
        System.out.print("Digite um número de 1 a 7 referênte aos dias da Semana: ");
        int Numero = scanner.nextInt();

        if (Numero >= 1 && Numero <= 7) {
            System.out.println("O dia da semana correspondente é " + dias[Numero - 1]);
        } else {
            System.out.println("Número inválido, digite um número entre 1 e 7");

            scanner.close();
        }
    }
}
