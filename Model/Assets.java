package Model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Assets {
    public static Font fuenteFPS, fuenteInterfaz;
    public static BufferedImage nave, planetaVivo, planetaMuerto, asteroides[], hoyosNegros[];

    public static void init() throws IOException, FontFormatException {
        nave = Loader.ImageLoader("../ObjetosEspaciales/Nave/player.png");
        planetaVivo = Loader.ImageLoader("../ObjetosEspaciales/Planeta/Vivo.png");
        planetaMuerto = Loader.ImageLoader("../ObjetosEspaciales/Planeta/NoVivo.png");
        asteroides = new BufferedImage[3];
        hoyosNegros = new BufferedImage[3];
        fuenteFPS = Loader.loadFont("../Resource/Fonts/HeavyDataNerdFont-Regular.ttf",20);
        fuenteInterfaz = Loader.loadFont("../Resource/Fonts/ProFontIIxNerdFontMono-Regular.ttf",20);
    }
}
