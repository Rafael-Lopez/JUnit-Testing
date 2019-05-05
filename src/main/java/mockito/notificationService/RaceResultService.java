package mockito.notificationService;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

public class RaceResultService {

    private final Logger logger;
    private Collection<Client> clients = new HashSet<Client>();

    public RaceResultService(Logger logger) {
        this.logger = logger;
    }

    public void send(Message message) {
        for(Client client : clients) {
            client.receive(message);
        }

        logger.logMessage(LocalDate.now(), message);
    }

    public void addSubscriber(Client client) {
        this.clients.add(client);
    }

    public void removeSubscriber(Client client) {
        clients.remove(client);
    }
}
