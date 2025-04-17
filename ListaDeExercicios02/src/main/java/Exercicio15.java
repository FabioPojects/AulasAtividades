import java.util.Scanner;

public class Exercicio15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] meses = {"janeiro", "fevereiro", "março", "abril 3", "maio", "junho 5", "julho", "agosto", "setembro 8",
        "outubro", "novembro 10", "dezembro"};

        System.out.println("Qual o dia do seu aniversario?");
        Integer dia = scanner.nextInt();

        System.out.println("Qual o mês do seu aniversario?");
        Integer mes = scanner.nextInt();

        if (mes > 12 || mes < 1){
            System.out.println("Mês inválido");
        }else {
            if (mes == 4 || mes == 6 || mes == 9 || mes == 11){
                if (dia > 30){
                    System.out.println("Dia do Mês inválido.");
                }else {
                    System.out.println("Parabéns! Seu aniversário é válido! %d %s".formatted(dia, meses[mes - 1]));
                }
            }else {
                if (dia > 31){
                    System.out.println("Dia do Mês inválido.");
                }else {
                    System.out.println("Parabéns! Seu aniversário é válido! %d de %s".formatted(dia, meses[mes - 1]));
                }
            }
        }

    }
}
