package una.motor.estructuras;
import una.motor.estructuras.IteradorLista;
import una.motor.estructuras.Nodo;

import java.io.Serializable;

public class ListaDoble<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int tamanio;

    public ListaDoble(){
        this.primero = null;
        this.ultimo = null;
        tamanio = 0;
    }


    public Iterador<T> getIterador(){
        return new IteradorLista<>(primero);
    }

    public boolean isEmpty(){
        return primero ==null;
    }



    private Nodo<T> getPosicion(int pos){
        Nodo<T> temp = primero;
        int i = 0;
        while (i< pos){
            temp = temp.getSiguiente();
            i++;
        }
        return temp;
    }




    public void insertarInicio(T e){
        Nodo<T> nuevo = new Nodo<T>(e);

        if(isEmpty()){
            primero = nuevo;
            ultimo = nuevo;
        }else{
            nuevo.setSiguiente(primero);
            primero.setAnterior(nuevo);
            primero = nuevo;
        }
        tamanio ++;
    }

    public void insertarFinal(T e) {
        Nodo<T> nuevo = new Nodo<T>(e);

        if (isEmpty()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
        tamanio++;
    }

    public boolean eliminarPosicion(int pos){
        if(pos<0 || pos >=tamanio){
            return false;
        }
        if (tamanio == 1) {
            primero = null;
            ultimo = null;
            tamanio--;
            return true;
        }
        if (pos == 0) {
            primero = primero.getSiguiente();
            primero.setAnterior(null);
        }
        else {
            Nodo<T> temp = getPosicion(pos);
            Nodo<T> anterior = temp.getAnterior();
            Nodo<T> siguiente = temp.getSiguiente();
            //puenteo
            anterior.setSiguiente(siguiente);
            siguiente.setAnterior(anterior);
            temp.setSiguiente(null);
            temp.setAnterior(null);
        }
        tamanio--;
        return true;
    }

    //metodo con iterador
    public boolean eliminarElemento(T e){
        Iterador<T> ite= getIterador();
        int i = 0;
        while (ite.hasNext()){
            T dato = ite.siguiente();
            if(dato.equals(e)) {
                return eliminarPosicion(i);
            }
            i++;
        }
        return false;
    }

    public int getTamanio(){
        return tamanio;
    }
}
