public class LightingSystem {
    private boolean isOn = false;

    public void turnOn() {
        isOn = true;
        System.out.println("Lights: All lights turned on.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Lights: All lights turned off.");
    }
    public boolean isOn() {
        return isOn;
    }
}
