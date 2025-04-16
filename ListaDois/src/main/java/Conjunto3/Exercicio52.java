package Conjunto3;

public class Exercicio52 {
    public static void main(String[] args) {
        long totalGraos = 0;
        long graosNaCasa = 1;

        for (int i = 1; i <= 64; i++) {
            totalGraos += graosNaCasa;
            graosNaCasa *= 2;
        }

        long sacosDeArroz = totalGraos / 5_966;
        System.out.println("Total de grãos de arroz: " + totalGraos);
        System.out.println("Total de sacos de arroz: " + sacosDeArroz);
    }
}