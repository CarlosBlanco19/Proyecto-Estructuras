package una.motor.similitud;
import  una.motor.model.VectorCaracteristico;

public interface IFuncionSimilitud {
    double calcularSimilitud(VectorCaracteristico v1, VectorCaracteristico v2);
}