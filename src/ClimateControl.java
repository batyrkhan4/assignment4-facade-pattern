public class ClimateControl {
    private double temperature = 22.0; //default value
    public void setTemperature(float degrees) {
        this.temperature = degrees;
        System.out.println("Climate: Temperature set to " + degrees + " degrees.");
    }

    public void turnOff() {
        System.out.println("Climate: Heating and cooling turned off (energy saving mode).");
    }
    public double getTemperature() {
        return temperature;
    }
}
