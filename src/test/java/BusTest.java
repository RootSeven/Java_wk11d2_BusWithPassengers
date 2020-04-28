import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusTest {

    private Bus bus;
    private Person person1;
    private BusStop busStop;

    @Before
    public void before(){
        busStop = new BusStop("France" );
        bus = new Bus( "Mars", 2 );
        person1 = new Person();
    }

    @Test
    public void getDestination() {
        assertEquals("Mars", bus.getDestination());
    }

    @Test
    public void getCapacity() {
        assertEquals( 2, bus.getCapacity() );
    }

    @Test
    public void busStartsEmpty(){
        assertEquals( 0, bus.passengerCount() );
    }

    @Test
    public void busCanAddPassengerNotAtCapacity(){
        bus.addPassenger(person1);
        assertEquals( 1, bus.passengerCount() );
    }
    @Test
    public void busCanAddPassengerAtCapacity(){
        bus.addPassenger(person1);
        bus.addPassenger(person1);
        bus.addPassenger(person1);
        assertEquals( 2, bus.passengerCount() );
    }

    @Test
    public void busCanRemovePassenger(){
        bus.addPassenger(person1);
        bus.removePassenger(person1);
        assertEquals( 0, bus.passengerCount() );
    }

    @Test
    public void canPickUpPassenger(){
        busStop.addPerson(person1);
        bus.pickUp( person1, busStop );
        assertEquals( 0, busStop.getQueueLength() );
        assertEquals( 1, bus.passengerCount() );
    }

}
