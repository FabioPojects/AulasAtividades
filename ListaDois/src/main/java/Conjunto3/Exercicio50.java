package Conjunto3;

public class Exercicio50 {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;

        for (int i = 3; i <= 5; i++) {
            int fib = a + b;
            a = b;
            b = fib;
        }
        System.out.println("O Quinto número da sequência de Fibonacci é " + b);
    }
}