import java.util.Scanner;

public class Exercicio29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Primeiro ponto do plano cartesiano: (x,x)");
        String primeiroPonto = scanner.nextLine();
        Integer x1 = Integer.valueOf(primeiroPonto.substring(0,1));
        Integer y1 = Integer.valueOf(primeiroPonto.substring(2,3));

        System.out.println("Segundo ponto do plano cartesiano: (x,x)");
        String segundoPonto = scanner.nextLine();
        Integer x2 = Integer.valueOf(segundoPonto.substring(0,1));
        Integer y2 = Integer.valueOf(segundoPonto.substring(2,3));

        if (x1 == x2 && x2 == y2){
            System.out.println("É um ponto.");
        }else if (x1 ==  x2){
            System.out.println("É uma reta horizontal.");
        }else if (y1 == y2){
            System.out.println("É uma reta vertical.");
        }else {
            System.out.println("Retângulo");

            System.out.println("Terceiro ponto do plano cartesiano: (x,x)");
            String terceiroPonto = scanner.nextLine();
            Integer x3 = Integer.valueOf(segundoPonto.substring(0,1));
            Integer y3 = Integer.valueOf(segundoPonto.substring(2,3));
            Integer xAlto = x1;
            Integer yDireita = y1;
            Integer xBaixo = x2;
            Integer yEsquerda = y2;

            if (x1 > x2){
                xAlto = x1;
                xBaixo = x2;
            }else {
                xAlto = x2;
                xBaixo = x1;
            }

            if(y1 > y2){
                yDireita = y1;
                yEsquerda = y2;
            }else{
                yDireita = y1;
                yEsquerda = y2;
            }

            if (x3 > xAlto && y3 > yDireita){
                System.out.println("Acima e à direita.");
            } else if (x3 > xAlto && y3 < yEsquerda) {
                System.out.println("Acima e à esquerda.");
            }else if(x3 > xAlto){
                System.out.println("Acima...");
            } else if (x3 < xBaixo && y3 > yDireita){
                System.out.println("Abaixo e à direita.");
            } else if (x3 < xBaixo && y3 < yEsquerda) {
                System.out.println("Abaixo e à esquerda.");
            }else if(x3 < xBaixo){
                System.out.println("Abaixo...");
            }else if (y3 > yDireita){
                System.out.println("À direita.");
            }else if (y3 < yEsquerda){
                System.out.println("À esquerda.");
            }else if(x3 < xAlto && x3 > xBaixo && y3 < yDireita && y3 > yEsquerda){
                System.out.println("Dentro.");
            }else {
                System.out.println("Em cima da linha.");
            }


        }

    }
}
