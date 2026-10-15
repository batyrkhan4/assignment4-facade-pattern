public class SecuritySystem {
    private boolean isArmed = false;
    public void arm() {
        isArmed = true;
        System.out.println("Security: System ARMED. Motion sensors active.");
    }

    public void disarm() {
        isArmed = false;
        System.out.println("Security: System DISARMED.");
    }
    public boolean isArmed() {
        return isArmed;
    }
}