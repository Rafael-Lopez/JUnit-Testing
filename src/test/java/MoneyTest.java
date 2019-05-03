import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnitParamsRunner.class)
public class MoneyTest {

    private final Object[] getMoney(){
        return  new Object[]{
          new Object[]{10, "USD"},
          new Object[]{20, "EUR"}
        };
    }

    @Test
    @Parameters(method = "getMoney")
    public void constructorShouldSetAmountAndCurrency(int amount, String currency){
        Money money = new Money(amount, currency);

        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());
        assertNotNull(money);
    }
}
