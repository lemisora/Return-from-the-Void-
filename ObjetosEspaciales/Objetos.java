package ObjetosEspaciales;
import java.util.Random;
public class Objetos{
  //Variables que representan las caracteristicas de los objetos espaciales
  protected int Velocidad;
  protected int posX; //Coordenadas verticales del objeto
  protected int posY; //Coordenadas horizontales del objeto
  protected Random aleatorio = new Random(); //Se crea el objeto que lanza numeros aleatorios

  public Objetos(int sp, int x, int y){ //Constructor de los objetos
     this.Velocidad = sp;
     this.posX = x;
     this.posY = y;
  }

  //Getters y setters
  public void setVelocidad(){
    //La cantidad de velocidad que puede tener un objeto varia en el rango de 30 a 5000 km
    this.Velocidad = aleatorio.nextInt(5000)+30;
  }

  public int setposY(int y){
    //Asumiendo que se ejecuta en una terminal de 80x25 se determina el diferencial mediante los intervalos de 30 a 1000, 1000 a 2000 sucesivamente hasta llegar a los 5000 km
    int avanzaY = 0;
    if(this.Velocidad >= 30 && this.Velocidad < 1000){
      avanzaY = 1;
    }else if(this.Velocidad >= 1000 && this.Velocidad < 2000){
      avanzaY = 2;
    }else if(this.Velocidad >= 2000 && this.Velocidad < 3000){
      avanzaY = 3;
    }else if(this.Velocidad >= 3000 && this.Velocidad < 4000){
      avanzaY = 5;
    }else if(this.Velocidad >= 4000 && this.Velocidad < 5000){
      avanzaY = 8;
    }
    return avanzaY;
  }

  public int getVelocidad(){
    return Velocidad;
  }
  public int getposX() {
    return posX;
  }
  public int getposY(){
    return posY;
  }
} 