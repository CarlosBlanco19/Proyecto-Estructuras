package una.motor.persistencia;

import una.motor.estructuras.ListaDoble;
import una.motor.model.ImagenIndex;

import java.io.*;

public class PersistenciaBinario {

    public void guardar(ListaDoble<ImagenIndex> imagenes, String ruta)throws IOException{
        try (FileOutputStream fos = new FileOutputStream(ruta);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(imagenes);
        }
    }

    //falta codigo por hacer, relacionado con exceptions
    public ListaDoble<ImagenIndex> cargar(String ruta) throws IOException, ClassNotFoundException{
        try(FileInputStream fis = new FileInputStream(ruta); ObjectInputStream ois = new ObjectInputStream(fis)){
            Object leido = ois.readObject();
            return (ListaDoble<ImagenIndex>) leido;
        }
    }

}
