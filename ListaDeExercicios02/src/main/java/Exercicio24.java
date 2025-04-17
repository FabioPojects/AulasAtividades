import java.time.LocalDateTime;
import java.util.Scanner;

public class Exercicio24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Dia: ");
        Integer dia = scanner.nextInt();
        System.out.println("Mês: ");
        Integer mes = scanner.nextInt();
        System.out.println("Ano: ");
        Integer ano = scanner.nextInt();

        if (mes == 4 || mes == 6 || mes == 9 || mes == 11){
            if (dia > 30){
                System.out.println("Dia inváliddo");
            }else {
                System.out.println("Data válida.");
            }
        }else if (mes == 2){
            if (ano % 4 == 0 && ano % 100 == 0){
                if (dia > 29){
                    System.out.println("Dia inváliddo");
                }else {
                    System.out.println("Data válida.");
                }
            }else {
                if (dia > 28){
                    System.out.println("Dia inváliddo");
                }else {
                    System.out.println("Data válida.");
                }
            }
        }else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
            if (dia > 31){
                System.out.println("Dia inváliddo");
            }else {
                System.out.println("Data válida.");
            }
        }else{
            System.out.println("Mês inválido.");
        }

    }
}
