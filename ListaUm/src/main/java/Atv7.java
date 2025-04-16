public class Atv7 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100 ; i++) {
            if (i % 3 == 0) {
                int ResultadoInt = i / 2;
                double ResultadoDouble = (double) i / 2;

                System.out.println("Número: " + i + " | int: " + ResultadoInt + " | Double: " + ResultadoDouble);

            }

        }
    }
}
