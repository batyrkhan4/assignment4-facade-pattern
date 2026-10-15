import java.util.Objects;
public class SmartHomeFacade {
    private DoorLockManager doors;
    private SecuritySystem security;
    private ClimateControl climate;
    private LightingSystem lights;

    public SmartHomeFacade(DoorLockManager doors, SecuritySystem security, ClimateControl climate, LightingSystem lights) {
        this.doors = Objects.requireNonNull(doors, "DoorLockManager cannot be null");
        this.security = Objects.requireNonNull(security, "SecuritySystem cannot be null");
        this.climate = Objects.requireNonNull(climate, "ClimateControl cannot be null");
        this.lights = Objects.requireNonNull(lights, "LightingSystem cannot be null");
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
