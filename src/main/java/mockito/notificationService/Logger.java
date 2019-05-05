package mockito.notificationService;

import java.time.LocalDate;

public interface Logger {
    void logMessage(LocalDate date, Message message);
}
