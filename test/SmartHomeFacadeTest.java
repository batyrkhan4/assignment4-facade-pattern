import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmartHomeFacadeTest {
    private SmartHomeFacade facade;
    private LightingSystem lights;
    private ClimateControl climate;
    private SecuritySystem security;
    private DoorLockManager doors;
    private HomeNotificationService notifications;


    @BeforeEach
    public void setUp() {
        // Build
        lights = new LightingSystem();
        climate = new ClimateControl();
        security = new SecuritySystem();
        doors = new DoorLockManager();
        notifications = new ConsoleNotificationService();
        facade = new SmartHomeFacade(doors, security, climate, lights, notifications);
    }

    @Test
    public void testEnterHome() {
        // Operate
        facade.enterHome();

        // Check
        assertTrue(lights.isOn(), "Light should be turned on");
        assertFalse(security.isArmed(), "Security should be disarmed");
        assertEquals(22.0, climate.getTemperature(), "Temperature should be set to normal");
        assertFalse(doors.isLocked(), "Doors should be unlocked");
    }

    @Test
    public void testLeaveHome() {
        // Operate
        facade.leaveHome();

        // Check
        assertFalse(lights.isOn(), "Light should be turned off");
        assertTrue(security.isArmed(), "Security should be armed");
        assertTrue(doors.isLocked(), "Doors should be locked");
    }

    @Test
    public void testNightMode() {
        // Operate
        facade.nightMode();

        // Check
        assertFalse(lights.isOn(), "Light should be turned off");
        assertTrue(doors.isLocked(), "Doors should be locked");
        assertEquals(19.0, climate.getTemperature(), "Temperature should be lowered for the night");
    }

    @Test
    public void testConstructorRejectsNullDoors() {
        assertThrows(NullPointerException.class, () -> new SmartHomeFacade(
                        null, new SecuritySystem(), new ClimateControl(), new LightingSystem(), new ConsoleNotificationService()),
                "DoorLockManager cannot be null"
        );
    }

    @Test
    public void testLeaveHomeSendsNotification() {
        FakeHomeNotificationService fakeNotifications = new FakeHomeNotificationService();
        facade = new SmartHomeFacade(doors, security, climate, lights, fakeNotifications);

        facade.leaveHome();
        assertTrue(fakeNotifications.getMessages().contains("--- Home is secured ---\n"), "Facade should send a home secured notification");
    }
}