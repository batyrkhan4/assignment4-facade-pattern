import java.util.ArrayList;
import java.util.List;

public class FakeHomeNotificationService implements HomeNotificationService {
    private final List<String> messages = new ArrayList<>();

    @Override
    public void notify(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }
}
