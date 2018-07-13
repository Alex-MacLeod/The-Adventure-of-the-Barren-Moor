package player;

import game.character.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    @Test
    public void addPoints_shouldAdd10000ToPlayerScore() {
        Player testPlayer1 = new Player("David");

        assertEquals(0, testPlayer1.getScore());

        testPlayer1.addPoints(10000);
        assertEquals(10000, testPlayer1.getScore());
    }

    @Test
    public void addPoints_shouldAddAnyValueToPlayerScore() {
        int pointsToAdd = 5000;
        Player testPlayer2 = new Player ("Procopis");

        assertEquals(0, testPlayer2.getScore());

        testPlayer2.addPoints(pointsToAdd);
        assertEquals(pointsToAdd, testPlayer2.getScore());
    }

    @Test
    public void wins_shouldSetVictoriousToTrue() {
        Player testPlayer3 = new Player("Deaglan");

        assertFalse(testPlayer3.isVictorious());

        testPlayer3.wins();
        assertTrue(testPlayer3.isVictorious());
    }

//    @Test
//    public void decideNextAction_should() {
//
//    }

}
