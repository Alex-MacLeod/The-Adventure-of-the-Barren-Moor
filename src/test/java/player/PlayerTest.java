package player;

import game.character.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    @Test
    public void addPointsShouldAdd10000ToPlayerScore() {
        Player testPlayer1 = new Player("David");

        assertEquals(0, testPlayer1.getScore());

        testPlayer1.addPoints(10000);
        assertEquals(10000, testPlayer1.getScore());
    }

    @Test
    public void addPointsShouldAddAnyValueToPlayerScore() {
        int pointsToAdd = 5000;
        Player testPlayer2 = new Player("Procopis");

        assertEquals(0, testPlayer2.getScore());

        testPlayer2.addPoints(pointsToAdd);
        assertEquals(pointsToAdd, testPlayer2.getScore());
    }

    @Test
    public void addPointsShouldNotAllowPointDeduction() {
        int pointsToAdd = -5000;
        Player testPlayer3 = new Player("Ashley");

        assertEquals(0, testPlayer3.getScore());

        try {
            testPlayer3.addPoints(pointsToAdd);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(0, testPlayer3.getScore());
    }

    @Test
    public void winsShouldSetVictoriousToTrue() {
        Player testPlayer4 = new Player("Deaglan");

        assertFalse(testPlayer4.isVictorious());

        testPlayer4.wins();
        assertTrue(testPlayer4.isVictorious());
    }

}
