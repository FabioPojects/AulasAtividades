class Retangulo {
    int xMin, yMin, xMax, yMax;

    public Retangulo(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int xMin = Math.min(Math.min(x1, x2), Math.min(x3, x4));
        int xMax = Math.max(Math.max(x1, x2), Math.max(x3, x4));
        int yMin = Math.min(Math.min(y1, y2), Math.min(y3, y4));
        int yMax = Math.max(Math.max(y1, y2), Math.max(y3, y4));

        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public boolean interseta(Retangulo outro) {
        return !(this.xMax < outro.xMin || this.xMin > outro.xMax ||
                this.yMax < outro.yMin || this.yMin > outro.yMax);
    }
}

public class TesteRetangulo {
    public static void main(String[] args) {
        Retangulo r1 = new Retangulo(1, 1, 4, 1, 4, 3, 1, 3);
        Retangulo r2 = new Retangulo(2, 2, 5, 2, 5, 4, 2, 4);

        System.out.println("Os retângulos se interceptam? " + r1.interseta(r2));
    }
}