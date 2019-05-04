package junit.lab2;

import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

// 3.11.3 HashMap

public class HashMapTest {

    private final static String KEY_A = "objectA";
    private final static String KEY_B = "objectB";

    private Map map;
    private Object objectA;
    private Object objectB;

    @Before
    public void setUp(){
        map = new HashMap();
        objectA = new Object();
        objectB = new Object();
    }

    @Test
    public void shouldBeAbleToStoreAndRetrieveObject(){
        map.put(KEY_A, objectA);
        objectB = map.get(KEY_A);

        assertEquals(1, map.size());
        assertSame(objectA, objectB);
    }

    @Test
    public void shouldReplaceObjectWhenAddingNewOneWithSameKey(){
        map.put(KEY_A, objectA);
        map.put(KEY_A, objectB);

        assertEquals(1, map.size());
        assertNotSame(objectA, map.get(KEY_A));
    }

    @Test
    public void shouldClearValues(){
        map.put(KEY_A, objectA);
        map.put(KEY_B, objectB);

        assertEquals(2, map.size());

        map.clear();

        assertEquals(0, map.size());
    }

    @Test
    public void shouldAllowNullAsKey(){
        map.put(null, objectA);

        objectB = map.get(null);

        assertEquals(1, map.size());
        assertSame(objectA, objectB);
    }
}
