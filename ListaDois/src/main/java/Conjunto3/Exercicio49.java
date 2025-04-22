package Conjunto3;

public class Exercicio49 {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;

        System.out.println(a);
        System.out.println(b);

        for (int i = 3; i <= 50; i++) {
            int fib = a + b;
            System.out.println(fib);
            a = b;
            b = fib;
        }
    }
}