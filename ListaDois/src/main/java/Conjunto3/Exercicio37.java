package Conjunto3;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercicio37 {
    public static BigInteger calcularFatorial(BigInteger n) {
        BigInteger resultado = BigInteger.ONE;
        for (BigInteger i = BigInteger.TWO; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            resultado = resultado.multiply(i);
        }
        return resultado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número para calcular o fatorial: ");
        BigInteger numero = scanner.nextBigInteger();
        System.out.println("O fatorial de " + numero + " é: " + calcularFatorial(numero));
        scanner.close();
    }
}