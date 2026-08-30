package una.motor.similitud;

public class FabricaSimilitudCoseno implements FabricaSimilitudAbstracta{
    @Override
    public IFuncionSimilitud crearFuncionSimilitud() {
        return new SimilitudCoseno();
    }
}
