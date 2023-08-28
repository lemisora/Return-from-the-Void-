package ObjetosEspaciales;

public class Move {
    private double x,y;

    public Move(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Move(){
        x = 0;
        y = 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
