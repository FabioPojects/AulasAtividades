package org.example;

import javax.sound.midi.SysexMessage;

public class Atv10 {
    public static void main(String[] args) {
        System.out.println("Programa 3 variáveis");

        int A = 6;
        int B = 4;
        int C = A / B;

        System.out.println("O valor de A = " + A);
        System.out.println("O valor de B = " + B);
        System.out.println("O Resultado da Divisão de A pra B é de = " + C);

        /*/
        Observando o output dado neste exercício, obtemos o
        resultado de 1 e não 1.5 devido ao tipo da variável,
        como inserimos o tipo “int” nas 3 variáveis, o valor que
        ela nos retorna é um número inteiro, ou seja, excluíndo
        qualquer tipo de resto obtido pela conta.
         */
    }
}
