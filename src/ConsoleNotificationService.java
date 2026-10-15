public class ConsoleNotificationService implements HomeNotificationService {
    @Override
    public void notify(String message) {
        System.out.println(message);
    }
}
