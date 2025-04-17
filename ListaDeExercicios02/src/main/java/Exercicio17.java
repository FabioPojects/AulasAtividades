import java.util.Scanner;

public class Exercicio17 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] meses = {"janeiro", "fevereiro", "março", "abril 3", "maio", "junho 5", "julho", "agosto", "setembro 8",
                "outubro", "novembro 10", "dezembro"};

        System.out.println("Qual o dia do seu aniversario?");
        Integer dia = scanner.nextInt();

        System.out.println("Qual o mês do seu aniversario?");
        Integer mes = scanner.nextInt();

        String trimestre = "";
        if (mes < 4){
            trimestre = "1°";
        }else if (mes < 7){
            trimestre = "2°";
        }else if (mes < 10){
            trimestre = "3°";
        }else {
            trimestre = "4°";
        }

        String signo = "";
        if ((mes == 1 && dia >= 20) || (mes == 2 && dia <= 18)) {
            signo = "Aquário";
        } else if ((mes == 2 ) || (mes == 3 && dia <= 20)) {
            signo = "Peixes";
        } else if ((mes == 3) || (mes == 4 && dia <= 19)) {
            signo = "Áries";
        } else if ((mes == 4) || (mes == 5 && dia <= 20)) {
            signo = "Touro";
        } else if ((mes == 5 ) || (mes == 6 && dia <= 20)) {
            signo = "Gêmeos";
        } else if ((mes == 6) || (mes == 7 && dia <= 22)) {
            signo = "Câncer";
        } else if ((mes == 7) || (mes == 8 && dia <= 22)) {
            signo = "Leão";
        } else if ((mes == 8) || (mes == 9 && dia <= 22)) {
            signo = "Virgem";
        } else if ((mes == 9) || (mes == 10 && dia <= 22)) {
            signo = "Libra";
        } else if ((mes == 10) || (mes == 11 && dia <= 21)) {
            signo = "Escorpião";
        } else if ((mes == 11) || (mes == 12 && dia <= 21)) {
            signo = "Sagitário";
        } else if ((mes == 12) || (mes == 1 && dia <= 19)) {
            signo = "Capricórnio";
        } else {
            signo = "Data inválida!";
        }
            if (mes == 4 || mes == 6 || mes == 9 || mes == 11){
                if (dia > 30){
                    System.out.println("Dia do Mês inválido.");
                }else {
                    System.out.println("Parabéns! Seu aniversário é válido! %d de %s, %s trimestre. Seu signo é: %s".formatted(dia, meses[mes - 1], trimestre, signo));
                }
            }else {
                if (dia > 31){
                    System.out.println("Dia do Mês inválido.");
                }else {
                    System.out.println("Parabéns! Seu aniversário é válido! %d de %s, %s trimestre. Seu signo é: %s".formatted(dia, meses[mes - 1], trimestre, signo));
                }
            }

    }
}
