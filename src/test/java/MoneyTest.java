import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MoneyTest {

    @Test
    public void constructorShouldSetAmountAndCurrency(){
        Money money = new Money(10, "USD");

        assertEquals(10, money.getAmount());
        assertEquals("USD", money.getCurrency());
        assertNotNull(money);
    }
}
