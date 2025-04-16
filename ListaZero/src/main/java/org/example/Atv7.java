package org.example;

public class Atv7 {
    public static void main(String[] args) {
        int A = 5;
        int B = 10;

        System.out.println("Antes da troca: A = " + A + ", B = " + B);

        int temp = A;
        A = B;
        B = temp;

        System.out.println("Depois da troca: A = " + A + ", B = " + B);
    }
}
