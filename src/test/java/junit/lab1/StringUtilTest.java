package junit.lab1;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

//3.11.2 String Reverse

@RunWith(JUnitParamsRunner.class)
public class StringUtilTest {

    private StringUtils stringUtils;

    @Before
    public void setUp(){
        stringUtils = new StringUtils();
    }

    public Object[] getStrings(){
        return new String[][]{ {"abcd", "dcba"}, {"dcba", "abcd"}, {"a--a--", "--a--a"}};
    }

    @Test
    @Parameters(method = "getStrings")
    public void shouldReverseString(String text, String reversed){
        String reversedString = stringUtils.reverse(text);

        assertNotNull(reversedString);
        assertTrue(reversed.equalsIgnoreCase(reversedString));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIAEForNullString(){
        stringUtils.reverse(null);
    }
}
