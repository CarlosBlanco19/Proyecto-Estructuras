package una.motor.model;
import java.io.Serializable;

public class ImagenIndex {

    private static final long serialVersionUID = 1L;
    private String ruta;
    private VectorCaracteristico vectorCaract;

    public ImagenIndex(String ruta, VectorCaracteristico vectorCaract) {
        this.ruta = ruta;
        this.vectorCaract = vectorCaract;
    }

    public String getRuta() {
        return ruta;
    }

    public VectorCaracteristico getVectorCaract() {
        return vectorCaract;
    }


    //metodo define cuando 2 imagenes son iguales, aqui es cuando se tiene la misma ruta
    @Override
    public boolean equals(Object objeto){ //si son iguales
        if(this == objeto){
            return true;
        }
        if(!(objeto instanceof ImagenIndex)){ //si son distintos objetos
            return false;
        }
        ImagenIndex imagenIndex = (ImagenIndex) objeto; //casteo
        return this.ruta.equals(imagenIndex.getRuta());
    }

}
