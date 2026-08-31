package una.motor.similitud;
import una.motor.estructuras.Vector;
import una.motor.model.VectorCaracteristico;

public class InterseccionHistogramas implements IFuncionSimilitud {
    public double calcularSimilitud(VectorCaracteristico v1, VectorCaracteristico v2) {
        Vector<Double> a = v1.getValores();
        Vector<Double> b = v2.getValores();
        int n = a.getTamanio();

        double sumaMin = 0.0;

        for (int i = 0; i < n; i++) { //sumatoria minimos entre a y b
            sumaMin += Math.min(a.getPosicion(i), b.getPosicion(i));
        }

        return sumaMin;
    }
}
