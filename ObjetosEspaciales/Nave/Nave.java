package ObjetosEspaciales.Nave;
import ObjetosEspaciales.Objetos;

import java.awt.event.KeyEvent;

public class Nave extends Objetos{
  protected int Balas;
  protected int Capsulas;
  protected int posXin;

  private boolean A = false, D = false, SPACE = false;
  public Nave(int sp, int x, int y){
    super(sp,x,y);
    this.posXin = x*2;
  }

  @Override
  public void moveY() {}

  @Override
  public void generaPosicion() {}

  @Override
  public void update() {

  }

  public void moveX(boolean A, boolean D, boolean SP) {
    this.A = A;
    this.D = D;
    this.SPACE = SP;

    if(A){
      this.posX = posX - 5;
    } else if (D) {
      this.posX = posX + 5;
    }

    if(posX >= posXin - 70){
      posX = posXin - 70;
    }else if(posX <= 20){
      posX = 20;
    }
  }


}
