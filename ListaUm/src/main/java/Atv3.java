public class Atv3 {
    public static void main(String[] args) {
        int numero = 50;

        for (int i = 2; i < numero; i++) {
            if (Primo(i)) {
                System.out.println( i + " ");
            }
        }
    }

    public static boolean Primo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
