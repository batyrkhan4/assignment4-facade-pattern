public class Main {
    public static void main(String[] args) {
        DoorLockManager doors = new DoorLockManager();
        SecuritySystem security = new SecuritySystem();
        ClimateControl climate = new ClimateControl();
        LightingSystem lights = new LightingSystem();
        ConsoleNotificationService notifications = new ConsoleNotificationService();
        SmartHomeFacade facade = new SmartHomeFacade(doors, security, climate, lights,notifications);

        SmartHomeClient client = new SmartHomeClient(facade);
        client.run();
    }
}