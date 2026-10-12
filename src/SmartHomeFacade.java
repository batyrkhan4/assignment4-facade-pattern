public class SmartHomeFacade {
    private DoorLockManager doors;
    private SecuritySystem security;
    private ClimateControl climate;
    private LightingSystem lights;

    public SmartHomeFacade(DoorLockManager doors, SecuritySystem security, ClimateControl climate, LightingSystem lights) {
        this.doors = doors;
        this.security = security;
        this.climate = climate;
        this.lights = lights;
    }

    public void leaveHome() {
        System.out.println("\n--- Executing Scenario: LEAVING HOME ---");
        doors.lockAllDoors();
        lights.turnOff();
        security.arm();
        climate.turnOff();
        System.out.println("--- Home is secured ---\n");
    }

    public void enterHome() {
        System.out.println("\n--- Executing Scenario: ENTER HOME ---");
        doors.unlockAllDoors();
        lights.turnOn();
        security.disarm();
        climate.setTemperature(22);
        System.out.println("--- Welcome Home ---\n");
    }

    public void nightMode() {
        System.out.println("\n--- Executing Scenario: NIGHT MODE ---");
        doors.lockAllDoors();
        lights.turnOff();
        security.arm();
        climate.setTemperature(19);
        System.out.println("--- Good Night ---\n");
    }

}
