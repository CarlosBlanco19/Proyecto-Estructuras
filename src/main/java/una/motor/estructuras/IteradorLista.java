package una.motor.estructuras;

public class IteradorLista<T> implements Iterador<T> {
    private Nodo<T> actual;

    public IteradorLista(Nodo<T> primero){
        this.actual = primero;
    }

    @Override
    public boolean hasNext(){
        return actual !=null;
    }

    @Override
    public T siguiente(){
        T e = actual.getDato();
        actual = actual.getSiguiente();
        return e;
    }

}

