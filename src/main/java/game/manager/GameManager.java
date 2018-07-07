package game.manager;

import game.events.Event;
import game.player.Player;
import game.utils.Directions;
import game.utils.Input;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class GameManager {

	public int[] createPoint(int[] point) {
		if ((point[0] == 0 && point[1] == 0) || Math.abs(point[0]) > 3 || Math.abs(point[1]) > 3) {
			int xPoint = ThreadLocalRandom.current().nextInt(-3, 3 + 1);
			int yPoint = ThreadLocalRandom.current().nextInt(-3, 3 + 1);

			if (xPoint == 0 && yPoint == 0) {
			    createPoint(point);
            }

			point[0] = xPoint;
			point[1] = yPoint;
			return point;
		} else {
			return point;
		}
	}
	
	public float calculateDistance(int[] point) {
		return (float) Math.sqrt(point[0]*point[0] + point[1]*point[1]);
	}

	public Enum<Directions> findDirection(int[] point) {
		double angle = Math.atan2(point[1], point[0]);
		Directions eventDirection = null;
		if (angle <= Math.PI/8 && angle > -Math.PI/8) {
			eventDirection = Directions.EAST;
		} else if (angle <= 3*Math.PI/8 && angle > Math.PI/8) {
			eventDirection = Directions.NORTH_EAST;
		} else if (angle <= 5*Math.PI/8 && angle > 3*Math.PI/8) {
			eventDirection = Directions.NORTH;
		} else if (angle <= 7*Math.PI/8 && angle > 5*Math.PI/8) {
			eventDirection = Directions.NORTH_WEST;
		} else if (angle <= -7*Math.PI/8 || angle > 7*Math.PI/8) {
			eventDirection = Directions.WEST;
		} else if (angle <= -5*Math.PI/8 && angle > -7*Math.PI/8) {
			eventDirection = Directions.SOUTH_WEST;
		} else if (angle <= -3*Math.PI/8 && angle > -5*Math.PI/8) {
			eventDirection = Directions.SOUTH;
		} else if (angle <= -Math.PI/8 && angle > -3*Math.PI/8) {
			eventDirection = Directions.SOUTH_EAST;
		} else {
			System.out.println("Error");
		}
		return eventDirection;
	}
	
	public void walk(int[] point) {
		System.out.println("Do you want to go North, South, East, or West?");
		String direction = Input.scan.next();
		if ("North".equalsIgnoreCase(direction)) {
			point[1] = point[1] - 1;
			System.out.println("You walk north for one mile.");
		} else if ("South".equalsIgnoreCase(direction)) {
			point[1] = point[1] + 1;
			System.out.println("You walk south for one mile.");
		} else if ("East".equalsIgnoreCase(direction)) {
			point[0] = point[0] - 1;
			System.out.println("You walk east for one mile.");
		} else if ("West".equalsIgnoreCase(direction)) {
			point[0] = point[0] + 1;
			System.out.println("You walk west for one mile.");
		} else {
			System.out.println("Sorry, which direction?");
		}
	}

	public void checkCompass(int[] point) {
		System.out.println("The compass is pointing " + findDirection(point) + ".");
		System.out.println("The display reads: " + calculateDistance(point) + " miles.");
	}

	public void startEvent(HashMap<Integer, Event> H, Player player) {
		int random1to3 = 1 + (int)Math.round(Math.random())*2;
		Event event = H.get(random1to3);
		if (event.getClass().getSimpleName().equals("Treasure")) {
			System.out.println("You have found a great oak chest filled with treasure!");
		}
		player.addPoints(event.getValue());
		System.out.println("You earn " + event.getValue() + " points!");
	}
	

}
