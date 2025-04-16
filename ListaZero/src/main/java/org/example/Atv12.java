package org.example;

public class Atv12 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100 ; i++) {
            if (i % 3 == 0) {
                int resultadoInt = i / 2;
                double resultadoDouble = (double) i / 2;

                System.out.println("Números Int -> " + resultadoInt + " Números Double -> " + resultadoDouble);
            }
        }
    }
}
