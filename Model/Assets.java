package Model;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage nave, planetaVivo, planetaMuerto, asteroides[], hoyosNegros[];

    public static void init(){
        nave = Loader.ImageLoader("../ObjetosEspaciales/Nave/player.png");
    }
}
