package una.motor.similitud;
import una.motor.estructuras.Vector;
import una.motor.model.VectorCaracteristico;

public class SimilitudEuclidiana implements IFuncionSimilitud{
    @Override
    public double calcularSimilitud(VectorCaracteristico v1, VectorCaracteristico v2){
        Vector<Double> a = v1.getValores();
        Vector<Double> b= v2.getValores();

        int n= a.getTamanio();
        double sumaCuadradosDiferencia=0.0;

        for(int i=0; i<n; i++){ //sumatoria de formula euclidiana
            double dif= a.getPosicion(i)- b.getPosicion(i); //primero la resta
            sumaCuadradosDiferencia += dif*dif; //elevado al cuadrado
        }
        double distan= Math.sqrt(sumaCuadradosDiferencia);
         return 1.0/(1.0+distan); //volvemos a valores de la escala
    }
}
