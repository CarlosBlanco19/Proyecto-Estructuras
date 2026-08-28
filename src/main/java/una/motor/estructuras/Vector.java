package una.motor.estructuras;
//biblioteca para serializar en archivos binarios}
import java.io.Serializable;

public class Vector<T> implements Serializable{

    //atributo separado del objeto, para serializar y deserializar
    private static final long serialVersionUID = 1L;

    private Object[] elementos;
    int tamanio;
    int capacidad;

    public Vector(int capacidad) {
        this.capacidad = capacidad;
        this.tamanio = 0;
        this.elementos = new Object[capacidad];
    }

    public boolean isEmpty(){
        return tamanio ==0;
    }

    public int getTamanio(){
        return tamanio;
    }

    public Iterador<T> getIterador(){
        return new IteradorVector<>(this);
    }

    private void redimensionar(){
        int nuevaCapacidad = this.capacidad * 2;
        Object[] nuevoArreglo = new Object[nuevaCapacidad];
        for(int i =0; i<tamanio;i++){
            nuevoArreglo[i] = elementos[i];
        }
        elementos = nuevoArreglo;
        capacidad = nuevaCapacidad;
    }
    public void insertar(T e){
        if(tamanio == capacidad){
            redimensionar();
        }
        elementos[tamanio] = e;
        tamanio ++;
    }

    //Modificar despues
    public T getPosicion(int pos){
        if(pos < 0 || pos >= tamanio){
            return null;
        }
        return (T) elementos[pos];
    }

    //Modificar despues

    public void setPosicion(int pos, T e){
        if(pos < 0 || pos >= tamanio){
            return;
        }
        elementos[pos] =e;
    }
}
