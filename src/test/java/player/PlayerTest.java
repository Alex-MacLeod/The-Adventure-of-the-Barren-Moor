package player;

import game.player.Player;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    @Test
    public void checkScore_shouldSetVictoryIffOver10000Points() {
        Player testPlayer1 = new Player("David");
        Player testPlayer2 = new Player ("Procopis");
        testPlayer1.addPoints(10000);
        testPlayer2.addPoints(5000);

        testPlayer1.checkScore();
        assertTrue(testPlayer1.isVictory());

        testPlayer2.checkScore();
        assertFalse(testPlayer2.isVictory());
    }
}
