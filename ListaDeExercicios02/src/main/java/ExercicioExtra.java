public class ExercicioExtra {
    public static void main(String[] args) {
        var x = 13;
        var y = 0;

        while (y != 1){
            if (x % 2 == 0){
                y = x/2;
            }else{
                y = 3 * x + 1;
            }
            System.out.println(y);
            x = y;
        }

    }
}
