package una.motor.similitud;

import una.motor.estructuras.Vector;
import una.motor.similitud.IFuncionSimilitud;
import una.motor.model.VectorCaracteristico;
public class SimilitudCoseno implements IFuncionSimilitud {

    @Override
    public double calcularSimilitud(VectorCaracteristico v1, VectorCaracteristico v2) {

        Vector<Double> a= v1.getValores();
        Vector<Double> b= v2.getValores();
        int n= a.getTamanio(); // tienen mismo tamaño, indiferente de a  b

        double productoNum=0.0;
        double sumatoriaA=0.0;
        double sumatoriaB=0.0;
        for (int i = 0; i < a.getTamanio(); i++) {

            double valA=a.getPosicion(i);
            double valB= b.getPosicion(i);
            productoNum += valA*valB;
            sumatoriaA +=valA*valA;
            sumatoriaB +=valB*valB;
        }
        double denominador= Math.sqrt(sumatoriaA)*Math.sqrt(sumatoriaB);
        return (denominador==0.0) ? 0.0: (productoNum/denominador); //ternario :)
    }
}
