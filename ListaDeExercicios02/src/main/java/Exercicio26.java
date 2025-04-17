import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro horário: (xx:xx:xx)");
        String texto = scanner.nextLine();
        Integer hora = Integer.valueOf(texto.substring(0, 2));
        Integer minuto = Integer.valueOf(texto.substring(3, 5));
        Integer segundo = Integer.valueOf(texto.substring(6, 8));
        LocalTime primeiroHorario = LocalTime.of(hora, minuto, segundo);

        System.out.println("Digite o segundo horário: (xx:xx:xx)");
        texto = scanner.nextLine();
        hora = Integer.valueOf(texto.substring(0, 2));
        minuto = Integer.valueOf(texto.substring(3, 5));
        segundo = Integer.valueOf(texto.substring(6, 8));
        LocalTime segundoHorario = LocalTime.of(hora, minuto, segundo);

        Integer diferenca = - (primeiroHorario.toSecondOfDay() - segundoHorario.toSecondOfDay());
        System.out.println("Diferença de " + diferenca + " segundos.");
    }
}
