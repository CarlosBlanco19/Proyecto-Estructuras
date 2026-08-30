package una.motor.model;
import una.motor.estructuras.Vector;
import java.io.Serializable;
import java.awt.image.BufferedImage;


public class VectorCaracteristico {

    //para serializar y deserializar
    private static final long serialVersionUID = 1L;
    private Vector<Double> valores;
    private int cantBins;

    public Vector<Double> getValores() {
        return valores;
    }

    public int getCantBins(){
        return cantBins;
    }

    public VectorCaracteristico(int cantBins) {
        this.cantBins= cantBins;
        int tamanoTotal=cantBins * cantBins * cantBins; //formula numero bins elevado ala 3
        this.valores = new Vector<>(tamanoTotal);


        for(int i=0; i< tamanoTotal; i++){
            valores.insertar(0.0);
        }
        this.cantBins = cantBins;
    }

    private void incrementar(int i){
        Double valor = valores.getPosicion(i);
        valores.setPosicion(i, valor + 1);

    }

    public void normalizar(int ancho, int alto){
        double totalPix = alto*ancho;
        if (totalPix <= 0) { // evita posible caso extraño de division 0/0
            return;
        }
        for(int i=0; i < valores.getTamanio(); i++){
            Double valor = valores.getPosicion(i);
            valores.setPosicion(i, valor/totalPix);
        }
    }
    public void histograma(BufferedImage imagen){
        int alto = imagen.getHeight();
        int ancho = imagen.getWidth();
        int tamanoRango=256/cantBins;

        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                int pixel = imagen.getRGB(x, y);

                //mueve los bits y les aplica mascara para dejar el ultimo octeto y marcar su respectivo color
                int r = (pixel >> 16) & 0xFF;
                int g = (pixel >> 8) & 0xFF;
                int b = pixel & 0xFF;// no se le mueven espacios porque el azul ya esta en el ultimo octeto de defautl

                //mapeado con formula pdf

                int binR = Math.min(r / tamanoRango, cantBins - 1);
                int binG = Math.min(g / tamanoRango, cantBins - 1);
                int binB = Math.min(b / tamanoRango, cantBins - 1);

                int indice = (binR * cantBins * cantBins) + (binG * cantBins) + binB;
                incrementar(indice);
            }

        }
        normalizar(ancho, alto);
    }
}
