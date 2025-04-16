import java.util.ArrayList;
import java.util.Scanner;

class Carro {
    int totalKilometros;
    int totalLitros;

    public Carro(int totalKilometros, int totalLitros) {
        this.totalKilometros = totalKilometros;
        this.totalLitros = totalLitros;
    }

    public double calcularConsumoMedio() {
        return (double) totalKilometros / totalLitros;
    }
}

public class Atv12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Carro> listaCarros = new ArrayList<>();

        System.out.print("Quantos automóveis você tem? ");
        int quantidadeAutomoveis = scanner.nextInt();

        for (int i = 1; i <= quantidadeAutomoveis; i++) {
            System.out.println("\nInsira as informações para o automóvel " + i);

            System.out.print("Digite os quilômetros dirigidos: ");
            int totalKilometros = scanner.nextInt();

            System.out.print("Digite os litros de gasolina consumidos: ");
            int totalLitros = scanner.nextInt();

            if (totalLitros > 0) {
                listaCarros.add(new Carro(totalKilometros, totalLitros));
            } else {
                System.out.println("Nenhuma informação válida foi inserida para este automóvel.");
            }
        }

        double consumoGeralTotal = 0;
        int totalCarrosValidos = listaCarros.size();

        for (Carro carro : listaCarros) {
            consumoGeralTotal += carro.calcularConsumoMedio();
        }

        if (totalCarrosValidos > 0) {
            double mediaConsumoGeral = consumoGeralTotal / totalCarrosValidos;
            System.out.printf("\nA média de consumo geral dos carros é: %.2f km/l%n", mediaConsumoGeral);
        } else {
            System.out.println("\nNenhuma informação válida foi inserida para calcular a média.");
        }

        scanner.close();
    }
}