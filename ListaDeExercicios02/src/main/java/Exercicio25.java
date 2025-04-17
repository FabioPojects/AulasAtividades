import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Exercicio25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o horário: (xx:xx:xx)");
        String texto = scanner.nextLine();
        Integer hora = Integer.valueOf(texto.substring(0, 2));
        Integer minuto = Integer.valueOf(texto.substring(3, 5));
        Integer segundo = Integer.valueOf(texto.substring(6, 8));

        try{
            LocalTime.of(hora, minuto, segundo);
            System.out.println("Horário válido!");
        }catch (DateTimeException e){
            System.out.println("Horário inválido. %s".formatted(e.getMessage()));
        }

    }
}
