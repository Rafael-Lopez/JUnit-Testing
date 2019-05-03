import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClientTest {

    private Address addressA = new Address("Street A");
    private Address addressB = new Address("Street B");

    @Test
    public void afterCreationShouldHaveNoAddress(){
        Client client = new Client();

        assertEquals(0, client.getAddresses().size());
    }

    @Test
    public void shouldAllowToAddAddress(){
        Client client = new Client();
        client.addAddress(addressA);

        assertEquals(1, client.getAddresses().size());
        assertTrue(client.getAddresses().contains(addressA));
    }
    
    @Test
    public void shouldAllowToAddManyAddresses(){
        Client client = new Client();
        client.addAddress(addressA);
        client.addAddress(addressB);

        assertEquals(2, client.getAddresses().size());
        assertTrue(client.getAddresses().contains(addressA));
        assertTrue(client.getAddresses().contains(addressB));
    }
}
