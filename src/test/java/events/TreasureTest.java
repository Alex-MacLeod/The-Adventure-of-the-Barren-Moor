package events;

import game.event.Event;
import game.event.SmallTreasure;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TreasureTest {

    @Test
    public void playEvent_shouldSetEventAsCompleted(){
        Event testEvent = new SmallTreasure();
        assertFalse(testEvent.isCompleted());

        testEvent.play();
        assertTrue(testEvent.isCompleted());
    }
}
