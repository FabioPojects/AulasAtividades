public class Retangulo {
  int xMin, yMin, xMax, yMax;

    public Retangulo() {
    }

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

    public int getxMin() {
        return xMin;
    }

    public void setxMin(int xMin) {
        this.xMin = xMin;
    }

    public int getyMin() {
        return yMin;
    }

    public void setyMin(int yMin) {
        this.yMin = yMin;
    }

    public int getxMax() {
        return xMax;
    }

    public void setxMax(int xMax) {
        this.xMax = xMax;
    }

    public int getyMax() {
        return yMax;
    }

    public void setyMax(int yMax) {
        this.yMax = yMax;
    }

    public boolean intersetaOutroretangulo(Retangulo outro) {
      return !(this.xMax < outro.xMin || this.xMin > outro.xMax ||
              this.yMax < outro.yMin || this.yMin > outro.yMax);
  }
}


