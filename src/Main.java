public class Main {
    public static void main(String[] args) {
        DoorLockManager doors = new DoorLockManager();
        SecuritySystem security = new SecuritySystem();
        ClimateControl climate = new ClimateControl();
        LightingSystem lights = new LightingSystem();

        SmartHomeFacade facade = new SmartHomeFacade(doors, security, climate, lights);

        SmartHomeClient client = new SmartHomeClient(facade);
        client.run();
    }
}