import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> coordenadas1 = new ArrayList<>();
        List<Integer> coordenadas2 = new ArrayList<>();

        while (coordenadas1.size() <= 8){
            System.out.println("Digite x do primeiro retangulo: ");
            coordenadas1.add(scanner.nextInt());
            System.out.println("Digite y do primeiro retangulo: ");
            coordenadas1.add(scanner.nextInt());
        }
        while (coordenadas2.size() >= 8){
            System.out.println("Digite x do segundo retangulo: ");
            coordenadas2.add(scanner.nextInt());
            System.out.println("Digite y do segundo retangulo: ");
            coordenadas2.add(scanner.nextInt());
        }
        Retangulo retangulo1 = new Retangulo(coordenadas1.get(0), coordenadas1.get(1),coordenadas1.get(2), coordenadas1.get(3), coordenadas1.get(4),
                coordenadas1.get(5), coordenadas1.get(6), coordenadas1.get(7));
        Retangulo retangulo2 = new Retangulo(coordenadas2.get(0), coordenadas2.get(1),coordenadas2.get(2), coordenadas2.get(3), coordenadas2.get(4),
                coordenadas2.get(5), coordenadas2.get(6), coordenadas2.get(7));

        if (retangulo1.intersetaOutroretangulo(retangulo2)){
            System.out.println("Os retângulos se interceptam.");
        }
        System.out.println("Os retângulos não se interceptam.");

    }
}
