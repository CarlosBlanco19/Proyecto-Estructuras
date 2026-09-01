package una.motor.ordenamiento;

import una.motor.estructuras.Vector;
import una.motor.model.Resultado;

public class BubbleSort implements Sort {

    @Override
    public void ordenar(Vector<Resultado> resultados) {

        for (int i =0; i<resultados.getTamanio() -1; i++) {
            for (int j= 0; j< resultados.getTamanio()- i-1; j++) {

                double temp = resultados.getPosicion(j).getValorSimilitud();
                double tempSig = resultados.getPosicion(j + 1).getValorSimilitud();
                if (temp < tempSig) {

                    Resultado aux = resultados.getPosicion(j);
                    resultados.setPosicion(j, resultados.getPosicion(j + 1));
                    resultados.setPosicion(j + 1, aux);
                }
            }
        }
    }
}
