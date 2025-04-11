public class PPT1 {
    public static void main(String[] args) {
        int x = 13;

        while (x != 1) {
            int y;
            if (x % 2 == 0) {
                y = x / 2;
            } else {
                y = 3 * x + 1;
            }

            System.out.println(y);
            x = y;
        }

    }
}