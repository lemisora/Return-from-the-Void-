package ObjetosEspaciales;
public class PlanetaVivo extends Objetos{
  public PlanetaVivo(int sp, int x, int y){ //Constructor de la clase Planeta
    super(sp,x,y);
    this.posX = aleatorio.nextInt(x);
    this.posX = aleatorio.nextInt(y);
  }

  @Override
  public void moveY() {
    setVelocidad();
    posY = posY + setposY(this.posY);
  }

  @Override
  public void generaPosicion() {
    this.posX = 0;
    this.posY = 0;
  }

  @Override
  public void update() {
    moveY();
  }


}
