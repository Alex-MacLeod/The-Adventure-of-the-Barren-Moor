package game;

import game.event.Event;
import game.event.Introduction;
import game.event.Treasure;
import game.manager.Location;
import game.player.Player;
import game.util.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RunGame {

	public static void main(String[] args) {

		System.out.println("Welcome to The Adventure of the Barren Moor!");
		System.out.println("Please enter your name below:");
		String inputName = Input.scan.nextLine();
		Player player = new Player(inputName);

		Introduction introduction = new Introduction();

		List<Event> eventList = new ArrayList<>();
		eventList.add(new Treasure(5000));
		eventList.add(new Treasure(5000));
		eventList.add(new Treasure(10000));

		introduction.play();

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
