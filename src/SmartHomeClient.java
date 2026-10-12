public class SmartHomeClient {
    private SmartHomeFacade facade;

    public SmartHomeClient(SmartHomeFacade facade) {
        this.facade = facade;
    }

    public void run() {
        facade.enterHome();
        facade.leaveHome();
        facade.nightMode();
    }
}
