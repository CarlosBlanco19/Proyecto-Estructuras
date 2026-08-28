package una.motor.model;


public class Resultado {

    private ImagenIndex img;
    private double valorSimilitud;

    public Resultado(ImagenIndex img, double valorSimilitud) {
        this.img = img;
        this.valorSimilitud = valorSimilitud;
    }

    public ImagenIndex getImg() {
        return img;
    }

    public double getValorSimilitud() {
        return valorSimilitud;
    }
}
