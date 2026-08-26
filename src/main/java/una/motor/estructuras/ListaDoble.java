package una.motor.estructuras;
import una.motor.estructuras.Iterador;
import una.motor.estructuras.Nodo;

public class ListaDoble<T> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int tamanio;

    public ListaDoble(){
        this.primero = null;
        this.ultimo = null;
        tamanio = 0;
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
    public boolean isEmpty(){
        return primero ==null;
    }



    public void insertarIncio(T e){
        Nodo<T> nuevo = new Nodo<T>(e);

        if(isEmpty()){
            primero = nuevo;
            ultimo = nuevo;
        }else{
            nuevo.setSig(primero);
            primero.setAnt(nuevo);
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
            nuevo.setAnt(ultimo);
            ultimo.setSig(nuevo);
            ultimo = nuevo;
        }
        tamanio++;
    }

    public boolean eliminarPosicion(int pos){
        if(pos<0 || pos >=tamanio){
            return false;
        }

    }

    public void eliminarElemento(T e){

    }

    public int getTamanio(){
        return tamanio;
    }


}
