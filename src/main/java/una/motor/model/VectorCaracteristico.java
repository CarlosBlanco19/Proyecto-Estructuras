package una.motor.model;
import una.motor.estructuras.Vector;
import java.io.Serializable;
import java.awt.image.BufferedImage;


public class VectorCaracteristico implements Serializable {

    //para serializar y deserializar en binario
    private static final long serialVersionUID = 1L;
    private Vector<Double> valores;
    private int cantBins;

    public Vector<Double> getValores() {
        return valores;
    }

    public int getCantBins() {
        return cantBins;
    }

    public VectorCaracteristico(int cantBins) {
        this.cantBins = cantBins;
        int tamanoTotal = cantBins * cantBins * cantBins; //formula numero bins elevado ala 3
        this.valores = new Vector<>(tamanoTotal);


        for (int i = 0; i < tamanoTotal; i++) {
            valores.insertar(0.0);
        }
        this.cantBins = cantBins;
    }

    public void incrementar(int i) {
        Double valor = valores.getPosicion(i);
        valores.setPosicion(i, valor + 1);

    }

    public void normalizar(int ancho, int alto) {
        double totalPix = alto * ancho;
        if (totalPix <= 0) { // evita posible caso extraño de division 0/0
            return;
        }
        for (int i = 0; i < valores.getTamanio(); i++) {
            Double valor = valores.getPosicion(i);
            valores.setPosicion(i, valor / totalPix);
        }
    }
}
