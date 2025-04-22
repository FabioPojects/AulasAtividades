package Conjunto3;

import java.util.Arrays;
import java.util.Random;

public class Exercicio42 {
    public static void main(String[] args) {
        Random random = new Random();
        int totalGrupos = 40;

        System.out.println("Lista de 40 grupos de números sorteados (0 a 59):");

        for (int i = 1; i <= totalGrupos; i++) {
            int[] grupo = new int[3];

            for (int j = 0; j < grupo.length; j++) {
                grupo[j] = random.nextInt(60);
            }

            Arrays.sort(grupo);

            System.out.printf("Grupo %d: %d, %d, %d%n", i, grupo[0], grupo[1], grupo[2]);
        }
    }
}