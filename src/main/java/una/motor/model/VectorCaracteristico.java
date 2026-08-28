package una.motor.model;
import una.motor.estructuras.Vector;
import java.io.Serializable;

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
        this.valores = new Vector<>(cantBins);
        for(int i=0; i< cantBins; i++){
            valores.insertar(0.0);
        }
        this.cantBins = cantBins;
    }

    private void incrementar(int i){
        Double valor = valores.getPosicion(i);
        valores.setPosicion(i, valor + 1);

    }

    public void normalizar(int ancho, int alto){
        int totalPix = alto*ancho;

        for(int i=0; i < valores.getTamanio(); i++){
            Double valor = valores.getPosicion(i);
            valores.setPosicion(i, valor/totalPix);
        }
    }

}
