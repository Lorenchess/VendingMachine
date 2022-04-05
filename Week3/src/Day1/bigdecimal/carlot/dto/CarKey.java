package Day1.bigdecimal.carlot.dto;

public class CarKey {
    private String VIN;
    private boolean laserCut;

    public CarKey(String VIN) {
        this.VIN = VIN;
    }

    public String getVIN() {
        return VIN;
    }

    public boolean isLaserCut() {
        return laserCut;
    }

    public void setLaserCut(boolean laserCut) {
        this.laserCut = laserCut;
    }

    // plus getters, setters & appropriate constructors
}
