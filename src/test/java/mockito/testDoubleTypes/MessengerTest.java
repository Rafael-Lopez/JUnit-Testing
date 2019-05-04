package mockito.testDoubleTypes;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class MessengerTest {

    private final String CLIENT_EMAIL = "some@email.com";
    private final String MSG_CONTENT = "Some content";

    //For this example keep in mind that the order of how things are defined is not ideal, I only
    //did it this way for better understanding of what's happening. Order should be:
    //Create test doubles > Create SUT (no mock method()) > Expectations > SUT execution > Verifications
    @Test
    public void shouldSendEmail() {

        //Dummy object: required just to execute the test, but not really needed for anything useful.
        //Its methods are not invoked at all, or the result of calling them is of no importance.
        Template template = mock(Template.class);

        Client client = mock(Client.class);
        when(client.getEmail()).thenReturn(CLIENT_EMAIL);

        //Stub: we need to instruct it about what values to return when its methods are invoked
        TemplateEngine templateEngine = mock(TemplateEngine.class);
        when(templateEngine.prepareMessage(template, client)).thenReturn(MSG_CONTENT);

        //Spy: to verify that some communication between objects has taken place
        MailServer mailServer = mock(MailServer.class);

        //SUT creation
        Messenger sut = new Messenger(mailServer, templateEngine);
        //SUT execution
        sut.sendMessage(client, template);

        verify(mailServer).send(CLIENT_EMAIL, MSG_CONTENT);
    }
}
