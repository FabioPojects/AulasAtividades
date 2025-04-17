import java.util.Scanner;

public class Exercicio14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do mês: ");
        String mes = scanner.nextLine();

        if (mes.equalsIgnoreCase("janeiro")){
            System.out.println(1);
        }else if(mes.equalsIgnoreCase("fevereiro")){
            System.out.println(2);
        }else if (mes.equalsIgnoreCase("março")){
            System.out.println(3);
        }else if(mes.equalsIgnoreCase("abril")){
            System.out.println(4);
        }else if (mes.equalsIgnoreCase("maio")){
            System.out.println(5);
        }else if(mes.equalsIgnoreCase("junho")){
            System.out.println(6);
        }else if(mes.equalsIgnoreCase("julho")){
            System.out.println(7);
        }else if (mes.equalsIgnoreCase("agosto")){
            System.out.println(8);
        }else if(mes.equalsIgnoreCase("setembro")){
            System.out.println(9);
        }else if(mes.equalsIgnoreCase("outubro")){
            System.out.println(10);
        }else if(mes.equalsIgnoreCase("novembro")){
            System.out.println(11);
        }else {
            System.out.println(12);
        }
    }
}
