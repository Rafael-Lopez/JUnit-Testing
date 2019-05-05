package mockito.notificationService;

import java.util.Collection;
import java.util.HashSet;

public class RaceResultService {

    private Collection<Client> clients = new HashSet<Client>();

    public void send(Message message) {
        for(Client client : clients) {
            client.receive(message);
        }
    }

    public void addSubscriber(Client client) {
        this.clients.add(client);
    }

    public void removeSubscriber(Client client) {
        clients.remove(client);
    }
}
