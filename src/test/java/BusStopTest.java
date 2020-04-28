import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusStopTest {

    private BusStop busStop;
    private Person person1;

    @Before
    public void before() {
        busStop = new BusStop( "Olympus Mons");
        person1 = new Person();
    }

    @Test
    public void getName(){
        assertEquals("Olympus Mons", busStop.getName());
    }

    @Test
    public void queueStartsEmpty(){
        assertEquals( 0, busStop.getQueueLength() );
    }

    @Test
    public void canAddPerson() {
        busStop.addPerson(person1);
        assertEquals( 1, busStop.getQueueLength() );
    }

    @Test
    public void canRemovePersonFromQueue(){
        busStop.addPerson(person1);
        busStop.removePerson(person1);
        assertEquals( 0, busStop.getQueueLength() );
    }

}
