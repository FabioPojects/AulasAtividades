package Conjunto3;

import java.util.Random;

public class Exercicio34 {
    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("Impimindo 50 numeros de 1 a 100");
        for (int i = 0; i < 50 ; i++) {
            int numeroR = random.nextInt(100) + 1;
            System.out.println(numeroR);

        }

    }
}
