package ObjetosEspaciales.Planeta;

import ObjetosEspaciales.Objetos;

public class Planetas extends Objetos {
  private boolean tieneVida;
  private boolean listo = false;
  public Planetas(int sp, int x, int y) { //Constructor de la clase Planeta
    super(sp, x, y);
    generaPosicion(x, y);

    int a = aleatorio.nextInt(2)+1;
    if(a == 2){
      this.tieneVida = true;
    }else if(a == 1){
      this.tieneVida = false;
    }
  }

  public boolean isTieneVida() {
    return tieneVida;
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
}



