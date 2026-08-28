package una.motor.histograma;

public class ConfigHistograma {
    private int numBins;

    public ConfigHistograma(int numBins) {
        this.numBins = numBins;
    }

    public int getNumBins() {
        return numBins;
    }

    public void setNumBins(int numBins) {
        this.numBins = numBins;
    }

    public int getTamanioVector(){
        return numBins*numBins*numBins;
    }
}
