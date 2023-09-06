package Model;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {
    public static Font fuenteFPS, fuenteInterfaz;
    public static BufferedImage nave, fuegoNave, planetaVivo, planetaMuerto, Marte, asteroidImages[];

    public static void init() {
        fuenteFPS = Loader.loadFont("/Resource/Fonts/HeavyDataNerdFont-Regular.ttf",18);
        fuenteInterfaz = Loader.loadFont("/Resource/Fonts/ProFontIIxNerdFontMono-Regular.ttf",20);
        nave = Loader.ImageLoader("/ObjetosEspaciales/Nave/player.png");
        fuegoNave = Loader.ImageLoader("/ObjetosEspaciales/Nave/fire.png");
        planetaVivo = Loader.ImageLoader("/ObjetosEspaciales/Planeta/vivo.png");
        planetaMuerto = Loader.ImageLoader("/ObjetosEspaciales/Planeta/planeta_no_vivo.png");
        Marte = Loader.ImageLoader("/ObjetosEspaciales/Planeta/Marte.png");
        asteroidImages = new BufferedImage[3];

        for(int i = 0; i < 3; i++){
            asteroidImages[i] = Loader.ImageLoader("/ObjetosEspaciales/Asteroides/"+(i+1)+".png");
        }
    }
}
