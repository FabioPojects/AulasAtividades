package Conjunto3;

import java.util.Scanner;

public class Exercicio29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Primeiro ponto do plano cartesiano (formato x,y):");
        String primeiroPonto = scanner.nextLine();
        Integer x1 = Integer.valueOf(primeiroPonto.split(",")[0].trim());
        Integer y1 = Integer.valueOf(primeiroPonto.split(",")[1].trim());

        System.out.println("Segundo ponto do plano cartesiano (formato x,y):");
        String segundoPonto = scanner.nextLine();
        Integer x2 = Integer.valueOf(segundoPonto.split(",")[0].trim());
        Integer y2 = Integer.valueOf(segundoPonto.split(",")[1].trim());

        if (x1.equals(x2) && y1.equals(y2)) {
            System.out.println("É um ponto.");
        } else if (x1.equals(x2)) {
            System.out.println("É uma reta vertical.");
        } else if (y1.equals(y2)) {
            System.out.println("É uma reta horizontal.");
        } else {
            System.out.println("Retângulo");

            System.out.println("Terceiro ponto do plano cartesiano (formato x,y):");
            String terceiroPonto = scanner.nextLine();
            Integer x3 = Integer.valueOf(terceiroPonto.split(",")[0].trim());
            Integer y3 = Integer.valueOf(terceiroPonto.split(",")[1].trim());
            Integer xAlto = Math.max(x1, x2);
            Integer xBaixo = Math.min(x1, x2);
            Integer yDireita = Math.max(y1, y2);
            Integer yEsquerda = Math.min(y1, y2);

            if (x3 > xAlto && y3 > yDireita) {
                System.out.println("Acima e à direita.");
            } else if (x3 > xAlto && y3 < yEsquerda) {
                System.out.println("Acima e à esquerda.");
            } else if (x3 > xAlto) {
                System.out.println("Acima...");
            } else if (x3 < xBaixo && y3 > yDireita) {
                System.out.println("Abaixo e à direita.");
            } else if (x3 < xBaixo && y3 < yEsquerda) {
                System.out.println("Abaixo e à esquerda.");
            } else if (x3 < xBaixo) {
                System.out.println("Abaixo...");
            } else if (y3 > yDireita) {
                System.out.println("À direita.");
            } else if (y3 < yEsquerda) {
                System.out.println("À esquerda.");
            } else if (x3 > xBaixo && x3 < xAlto && y3 > yEsquerda && y3 < yDireita) {
                System.out.println("Dentro.");
            } else {
                System.out.println("Em cima da linha.");
            }
        }

        scanner.close();
    }
}