package una.motor.similitud;

public class FabricaInterseccion implements FabricaSimilitudAbstracta{
    @Override
    public IFuncionSimilitud crearFuncionSimilitud(){
        return new InterseccionHistogramas();
    };
}
