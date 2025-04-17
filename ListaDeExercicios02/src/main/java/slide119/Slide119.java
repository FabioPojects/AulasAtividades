package slide119;

public class Slide119 {
    public static void main(String[] args) {
        int graosInt = 1;
        Long graosLong = 1l;
        int quadroInt = 0;
        int quadroLong = 0;

        boolean jaChegouInt = false;
        boolean jaChegouLong = false;

        for (int i = 0; i <= 204; i++){
            System.out.println(graosInt);
            System.out.println(graosLong);
            graosInt += graosInt;
            graosLong += graosLong;

            if (graosInt < 0 && !jaChegouInt){
                quadroInt = i;
            }
            if (graosLong < 0 && !jaChegouLong){
                graosLong = (long) i;
            }
        }
        System.out.println("ultrapassou na vez " + quadroInt);
        System.out.println("ultrapassou na vez " + quadroLong);

    }
}
