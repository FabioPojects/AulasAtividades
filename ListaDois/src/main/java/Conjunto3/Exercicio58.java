package Conjunto3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio58 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Digite uma data no formato dd/MM/yyyy:");
        String dataStr = scanner.nextLine();

        LocalDate data = LocalDate.parse(dataStr, formatter);

        System.out.println("Digite a quantidade de dias a somar:");
        int dias = scanner.nextInt();

        LocalDate dataSomada = data.plusDays(dias);

        System.out.println("Nova data: " + dataSomada.format(formatter));

        scanner.close();
    }
}