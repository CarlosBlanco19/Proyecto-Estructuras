package una.motor.estructuras;

public class IteradorVector<T> implements Iterador<T> {

    private Vector<T> vector;
    private int posActual;

    public IteradorVector(Vector<T> v){
        this.vector = v;
        this.posActual =0;
    }

    @Override
    public boolean hasNext(){
        return posActual < vector.tamanio;
    }

    @Override
    public T siguiente(){
        T dato = vector.getPosicion(posActual);
        posActual++;
        return dato;
    }
}
