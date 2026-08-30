package una.motor.similitud;

public class  FabricaSimilitudEuclidiana implements FabricaSimilitudAbstracta {
    @Override
    public IFuncionSimilitud crearFuncionSimilitud() {
        return new SimilitudEuclidiana();
    }
}
