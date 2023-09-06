package ObjetosEspaciales.Asteroides;
import ObjetosEspaciales.Objetos;
public class Asteroide extends Objetos {
    private boolean listo = false;
    private boolean dibujar = true;
    private int tipoAsteroide; //Aqui se determina de que dimensiones sera el asteroide que se dibujara, 1 y es chico, 2 mediano y 3 grande
    public Asteroide(int sp, int x, int y) {
        super(sp, x, y);
        generaPosicion(x,y);
        tipoAsteroide = aleatorio.nextInt(3)+1;
    }

    @Override
    public void moveY() {
        setVelocidad();
        posY = posY + setposY();
    }

    @Override
    public void generaPosicion(int x, int y) {
        this.posY = aleatorio.nextInt(y);
        while(!listo){
            if(this.posX <= 50 || this.posX >= x-50){
                this.posX = aleatorio.nextInt(x) + 50;
            }
            if(this.posX > 50 && this.posX < x - 50) {
                this.listo = true;
            }
        }
    }

    @Override
    public void update() {
        moveY();
    }

    public int getTipoAsteroide() {
        return tipoAsteroide-1;
    }

    public boolean isDibujar() {
        return dibujar;
    }

    public void setDibujar(boolean dibujar) {
        this.dibujar = dibujar;
    }
}
