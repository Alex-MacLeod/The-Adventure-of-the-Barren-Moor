package game;

import game.events.Event;
import game.events.Treasure;
import game.manager.GameManager;
import game.player.Player;
import game.utils.Input;

import java.util.HashMap;

public class RunGame {

	public static void main(String[] args) {
		
		GameManager g = new GameManager();
		
		System.out.println("Welcome to The Adventure of the Barren Moor!");
		System.out.println("Please enter your name below:");
		String n = Input.scan.next();
		Player player = new Player(n);
		
		Event e1 = new Treasure(5000);
		Event e2 = new Treasure(5000);
		Event e3 = new Treasure(10000);
		
		HashMap<Integer, Event> H = new HashMap<>();
		H.put(1, e1);
		H.put(2, e2);
		H.put(3, e3);
		
		System.out.println("You awaken to find yourself alone, lying cold and wet on a barren moor.");
		System.out.println("Slowly, you pick yourself up from the ground and take in your bleak surroundings.");
		System.out.println("All around, you are surrounded by a thick grey fog. You cannot see much around you.");
		System.out.println("You can just about see a black weathered rock in front of you, struggling against"
				+ " being swallowed up by the fog.");
		System.out.println("You feel something strange in your pocket.");
		
		int[] point = {0, 0};
		g.createPoint(point);
		
		System.out.println("You take it out and examine it.");
		System.out.println("It looks a bit like a pocket watch. However, there is only one hand, "
				+ "and it has a small display.");
		System.out.println("The markings on it suggest that it might be a compass, but it definitely doesn't point north.");
		System.out.println("The display seems to show a distance. Is this device pointing you towards something?");
		System.out.println("You decide to follow it.");
		
		do {
			g.checkCompass(point);
			g.walk(point);
			System.out.println("You take a moment to check the device.");
			if (point[0] == 0 && point[1] == 0) {
				System.out.println("You can now see what the device was pointing you towards");
				g.startEvent(H, player);
				player.scoreCheck(player);
			}
			g.createPoint(point);
		} while (!player.isVictory());
		
		System.out.println("Congratulations, " + player.getName() + "! You have won the game");

	}

}
