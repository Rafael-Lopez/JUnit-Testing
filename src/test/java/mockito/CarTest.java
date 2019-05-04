package mockito;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class CarTest {

    private Car myFerrari = Mockito.mock(Car.class);

    //Introducing Mockito
    @Test
    public void testIfCarIsCar() {
        assertTrue(myFerrari instanceof Car);
    }

    @Test
    public void testDefaultBehaviourOfTestDouble() {
        assertFalse( "New Test Double should return False as boolean by default", myFerrari.needsFuel() );
        assertEquals("New Test Double should return 0.0 as double by default",0.0, myFerrari.getEngineTemperature(), 0.0 );
    }

    //Expectations
    @Test
    public void testStubbing() {
        assertFalse( "New Test Double should return False as boolean by default", myFerrari.needsFuel() );

        when( myFerrari.needsFuel() ).thenReturn( true );

        assertTrue( "After instructed, Test Double should return what we want", myFerrari.needsFuel() );

    }

    @Test(expected = RuntimeException.class)
    public void throwException() {
        when( myFerrari.needsFuel() ).thenThrow( RuntimeException.class );
        myFerrari.needsFuel();
    }

    //Verification
    @Test
    public void testVerification() {
        myFerrari.driveTo("Sweet home Alabama");
        myFerrari.needsFuel();

        verify(myFerrari).driveTo("Sweet home Alabama");
        //verify(myFerrari).driveTo("Sweet home Honolulu");
        verify(myFerrari).needsFuel();
        //verify(myFerrari).getEngineTemperature();
    }
}
