package ObjetosEspaciales.Nave;
import ObjetosEspaciales.Objetos;

import java.awt.event.KeyEvent;

public class Nave extends Objetos{
  protected int Balas;
  protected int Capsulas;

  private boolean A = false, D = false, SPACE = false;
  public Nave(int sp, int x, int y){
    super(sp,x,y);
    
  }

  @Override
  public void move(boolean A, boolean D, boolean SP) {
    this.A = A;
    this.D = D;
    this.SPACE = SP;

    if(this.A == true){
      this.posX = posX - 2;
    } else if (D == true) {
      this.posX = posX + 2;
    }
  }


}
