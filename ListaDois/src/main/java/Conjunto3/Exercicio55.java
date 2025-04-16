package Conjunto3;

import java.util.Scanner;

public class Exercicio55 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double MENSALIDADE = 50.00;
        final int MINUTOS_GERAIS = 100;
        final int MINUTOS_EXTRA_VAI_VAI = 50;
        final double VALOR_EXCEDENTE_O = 0.65;
        final double VALOR_EXCEDENTE_V = 0.20;
        final double FATOR_TELEFONE_FIXO = 0.5;

        int minutosRestantes = MINUTOS_GERAIS;
        int minutosExtraVaiVai = MINUTOS_EXTRA_VAI_VAI;
        double totalAPagar = MENSALIDADE;

        while (true) {
            System.out.print("Digite o tipo de ligação ('o' = outras operadoras, 'v' = Vai-Vai, 'f' = telefone fixo) ou 'sair' para encerrar: ");
            String tipo = scanner.next();

            if (tipo.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Digite a quantidade de minutos: ");
            int minutos = scanner.nextInt();

            if (tipo.equals("f")) {
                minutos = (int) Math.ceil(minutos * FATOR_TELEFONE_FIXO);
            }

            if (minutosRestantes > 0) {
                int minutosConsumidos = Math.min(minutosRestantes, minutos);
                minutosRestantes -= minutosConsumidos;
                minutos -= minutosConsumidos;
            }

            if (tipo.equals("v") && minutosExtraVaiVai > 0 && minutos > 0) {
                int minutosConsumidos = Math.min(minutosExtraVaiVai, minutos);
                minutosExtraVaiVai -= minutosConsumidos;
                minutos -= minutosConsumidos;
            }

            if (minutos > 0) {
                if (tipo.equals("o")) {
                    totalAPagar += minutos * VALOR_EXCEDENTE_O;
                } else if (tipo.equals("v")) {
                    totalAPagar += minutos * VALOR_EXCEDENTE_V;
                }
            }

            System.out.println("Minutos restantes no pacote geral: " + minutosRestantes);
            System.out.println("Minutos restantes no extra Vai-Vai: " + minutosExtraVaiVai);
            System.out.printf("Total a pagar até agora: R$ %.2f%n", totalAPagar);
        }

        System.out.printf("Encerrando o programa. Total final a pagar: R$ %.2f%n", totalAPagar);
        scanner.close();
    }
}