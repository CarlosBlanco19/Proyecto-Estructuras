package una.motor.estructuras;
import una.motor.estructuras.Iterador;

public class Nodo<T> {

    private T dato;
    private Nodo<T> siguiente;
    private Nodo<T> anterior;

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public T getDato() {
        return dato;
    }

    public Nodo<T> getAnterior(){
        return anterior;
    }

    public Nodo<T> getSiguiente(){
        return siguiente;
    }

    public void setDato(T dato){
        this.dato = dato;
    }

    public void setSig(Nodo<T> sig){
        this.siguiente = sig;
    }

    public void setAnt(Nodo<T> ant){
        this.anterior = ant;
    }

}
