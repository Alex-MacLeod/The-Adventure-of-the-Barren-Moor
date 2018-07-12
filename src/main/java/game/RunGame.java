package game;

import game.events.Event;
import game.events.Treasure;
import game.manager.LocationManager;
import game.player.Player;
import game.utils.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RunGame {

	public static void main(String[] args) {

		System.out.println("Welcome to The Adventure of the Barren Moor!");
		System.out.println("Please enter your name below:");
		String inputName = Input.scan.next();
		Player player = new Player(inputName);

		List<Event> eventList = new ArrayList<>();
		eventList.add(new Treasure(5000));
		eventList.add(new Treasure(5000));
		eventList.add(new Treasure(10000));
		
		System.out.println("You awaken to find yourself alone, lying cold and wet on a barren moor.");
		System.out.println("Slowly, you pick yourself up from the ground and take in your bleak surroundings.");
		System.out.println("All around, you are surrounded by a thick grey fog. You cannot see much around you.");
		System.out.println("You can just about see a black weathered rock in front of you, struggling against"
				+ " being swallowed up by the fog.");
		System.out.println("You feel something strange in your pocket.");
		
		System.out.println("You take it out and examine it.");
		System.out.println("It looks a bit like a pocket watch. However, there is only one hand, "
				+ "and it has a small display.");
		System.out.println("The markings on it suggest that it might be a compass, but it definitely doesn't point north.");
		System.out.println("The display seems to show a distance. Is this device pointing you towards something?");
		System.out.println("You decide to follow it.");

		LocationManager location = new LocationManager();

		do {
			location.checkCompass();
			location.walk();
			System.out.println("You take a moment to check the device.");
			if (location.isOrigin()) {
				int randomIndex = ThreadLocalRandom.current().nextInt(0, eventList.size());
				Event randomEvent = eventList.get(randomIndex);
				System.out.println("You can now see what the device was pointing you towards");

				randomEvent.playEvent();

				if (randomEvent.isCompleted()) {
					eventList.remove(randomEvent);
					player.addPoints(randomEvent.getValue());
					System.out.println("You earn " + randomEvent.getValue() + " points!");
					player.checkScore();
				} else {
					return;
				}
			}
			if (location.isOrigin() || Math.abs(location.getXCoord()) > 3 || Math.abs(location.getYCoord()) > 3) {
				location.refresh();
			}
		} while (!player.isVictorious());
		
		if (player.isVictorious()) {
			System.out.println("Congratulations, " + player.getName() + "! You have won the game");
		} else {
			System.out.println("You are lost in the barren moor forever");
			System.out.println("Bad luck, " + player.getName() + "! You have lost the game");
		}
	}

}
