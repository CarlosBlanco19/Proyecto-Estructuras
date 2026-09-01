package una.motor.histograma;


//procesar imagenes
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

import una.motor.model.VectorCaracteristico;

public class CalcularHistograma {

    private ConfigHistograma config;

    public CalcularHistograma(ConfigHistograma config) {
        this.config = config;
    }

    public VectorCaracteristico calcular(File arch) throws IOException {
        BufferedImage img = ImageIO.read(arch);
        return calcular(img);
    }

    //metodo sobrecargado
    //se implementa aqui para respetar responsabilidad unica
    public VectorCaracteristico calcular(BufferedImage imagen) {
        VectorCaracteristico vector = new VectorCaracteristico(config.getNumBins());

        int alto = imagen.getHeight();
        int ancho = imagen.getWidth();

        int cantBins = config.getNumBins();
        int tamanoRango = 256 / cantBins;

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                int pixel = imagen.getRGB(j, i);

                //mueve los bits y les aplica mascara para dejar el ultimo octeto y marcar su respectivo color
                int r = (pixel >> 16) & 0xFF;
                int g = (pixel >> 8) & 0xFF;
                int b = pixel & 0xFF;// no se le mueven espacios porque el azul ya esta en el ultimo octeto de defautl

                //mapeado con formula pdf

                int binR = Math.min(r / tamanoRango, cantBins - 1);
                int binG = Math.min(g / tamanoRango, cantBins - 1);
                int binB = Math.min(b / tamanoRango, cantBins - 1);

                int indx = (binR * cantBins * cantBins) + (binG * cantBins) + binB;
                vector.incrementar(indx);
            }

        }
        vector.normalizar(ancho, alto);


        return vector;
    }



}

