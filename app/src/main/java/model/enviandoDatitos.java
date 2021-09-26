package model;

public class enviandoDatitos {
    private String señalesMoviento;
    private int r,g,b;
    private int movimientoPixel;

    public enviandoDatitos() {


    }

    public enviandoDatitos(String señalesMoviento, int r, int g, int b, int movimientoPixel) {
        this.señalesMoviento = señalesMoviento;
        this.r = r;
        this.g = g;
        this.b = b;
        this.movimientoPixel = movimientoPixel;
    }

    public String getSeñalesMoviento() {
        return señalesMoviento;
    }

    public void setSeñalesMoviento(String señalesMoviento) {
        this.señalesMoviento = señalesMoviento;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getMovimientoPixel() {
        return movimientoPixel;
    }

    public void setMovimientoPixel(int movimientoPixel) {
        this.movimientoPixel = movimientoPixel;
    }
}
