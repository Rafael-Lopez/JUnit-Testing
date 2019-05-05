package mockito.notificationService;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;

public class RaceResultServiceTest {

    // Using JUnit execution model: JUnit creates a new instance of a test class before executing any test method
    // marked with the @Test annotation. All you have to do is to create instance fields instead of method variables.
    // Alternatively, you can introduce a setUp() method annotated with @Before
    private RaceResultService raceResultService = new RaceResultService();
    private Client clientA = mock(Client.class, "clientA");
    private Client clientB = mock(Client.class, "clientB");
    private Message message = mock(Message.class);

    @Test
    public void notSubscribedClientShouldNotReceivedMessage() {
        raceResultService.send(message);

        verify(clientA, never()).receive(message);
        verify(clientB, never()).receive(message);
    }

    @Test
    public void subscribedClientShouldReceivedMessage() {
        raceResultService.addSubscriber(clientA);
        raceResultService.send(message);

        verify(clientA).receive(message);
    }

    @Test
    public void allSubscribedClientsShouldReceivedMessages() {
        raceResultService.addSubscriber(clientA);
        raceResultService.addSubscriber(clientB);
        raceResultService.send(message);

        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }

    @Test
    public void shouldSendOnlyOneMessageToMultiSubscriber() {
        raceResultService.addSubscriber(clientA);
        raceResultService.addSubscriber(clientA);
        raceResultService.send(message);

        //By default, Mockito verifies that the method has been invoked exactly once
        verify(clientA).receive(message);
        //If you wanted to specify more times, you could do something like:
        //verify(clientA, times(3)).receive(message);
    }

    @Test
    public void unsubscribedClientsShoulNotdReceivedMessages() {
        raceResultService.addSubscriber(clientA);
        raceResultService.removeSubscriber(clientA);
        raceResultService.send(message);

        verify(clientA, never()).receive(message);
    }
}
