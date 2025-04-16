package Conjunto3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Eercicio57 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Informe a primeira data (dd/MM/yyyy):");
        String dataInicioStr = scanner.nextLine();
        System.out.println("Informe a segunda data (dd/MM/yyyy):");
        String dataFimStr = scanner.nextLine();

        LocalDate dataInicio = LocalDate.parse(dataInicioStr, formatter);
        LocalDate dataFim = LocalDate.parse(dataFimStr, formatter);

        if (dataInicio.isAfter(dataFim)) {
            LocalDate temp = dataInicio;
            dataInicio = dataFim;
            dataFim = temp;
        }

        System.out.println("As datas entre " + dataInicio.format(formatter) + " e " + dataFim.format(formatter) + " são:");
        LocalDate dataAtual = dataInicio;
        while (!dataAtual.isAfter(dataFim)) {
            System.out.println(dataAtual.format(formatter));
            dataAtual = dataAtual.plusDays(1);
        }

        scanner.close();
    }
}