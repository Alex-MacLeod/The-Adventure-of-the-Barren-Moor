package barrenMoor.barrenMoor;

import java.util.concurrent.ThreadLocalRandom;

public class Game {

	public int[] createPoint(int[] point) {
		if (Math.abs(point[0]) > 5 || Math.abs(point[1]) > 5) {
			int xPoint = ThreadLocalRandom.current().nextInt(-5, 5 + 1);
			int yPoint = ThreadLocalRandom.current().nextInt(-5, 5 + 1);
			point[0] = xPoint;
			point[1] = yPoint;
			return point;
		} else {
			return point;
		}
	}
	
	public double calculateDistance(int[] point) {
		double distance = Math.sqrt(point[0]*point[0] + point[1]*point[1]);
		return distance;
	}
	public Enum<Directions> findDirection(int[] point) {
		double angle = Math.atan2(point[1], point[0]);
		Directions eventDirection = null;
		if (angle <= Math.PI/16 && angle > -Math.PI/16) {
			eventDirection = Directions.East;
		} else if (angle <= 3*Math.PI/8 && angle > Math.PI/8) {
			eventDirection = Directions.NorthEast;
		} else if (angle <= 5*Math.PI/8 && angle > 3*Math.PI/8) {
			eventDirection = Directions.North;
		} else if (angle <= 7*Math.PI/8 && angle > 5*Math.PI/8) {
			eventDirection = Directions.NorthWest;
		} else if (angle <= -7*Math.PI/8 || angle > 7*Math.PI/8) {
			eventDirection = Directions.West;
		} else if (angle <= -5*Math.PI/8 && angle > -7*Math.PI/8) {
			eventDirection = Directions.SouthWest;
		} else if (angle <= -3*Math.PI/8 && angle > -5*Math.PI/8) {
			eventDirection = Directions.South;
		} else if (angle <= -Math.PI/8 && angle > -3*Math.PI/8) {
			eventDirection = Directions.SouthEast;
		} else {
			System.out.println("Error");
		}
		return eventDirection;
	}
	
	public int[] walk(int[] point) {
		System.out.println("Do you want to go North, South, East, or West?");
		String d = Input.scan.next();
		if (d.equals("North")) {
			point[1] = point[1] - 1;
			System.out.println("You walk " + d + " for one mile.");
		} else if (d.equals("South")) {
			point[1] = point[1] + 1;
			System.out.println("You walk " + d + " for one mile.");
		} else if (d.equals("East")) {
			point[0] = point[0] - 1;
			System.out.println("You walk " + d + " for one mile.");
		} else if (d.equals("West")) {
			point[0] = point[0] + 1;
			System.out.println("You walk " + d + " for one mile.");
		} else {
			System.out.println("Sorry, which direction?");
		}
		return point;
	}
	
	public void checkCompass(int[] point) {
		System.out.println("The compass is pointing " + findDirection(point) + ".");
		System.out.println("The dial reads " + calculateDistance(point) + " miles.");
	}
	
	public void startEvent(Player player, Event e) {
		player.score = player.score + e.value;
	}
	
	public void scoreCheck(Player player) {
		if (player.score > 10000) {
			player.setVictoryStatus(true);
			System.out.println("You have " + player.score + " points");
		} else {
			System.out.println("You have " + player.score + " points");
		}
	}
	
	public void win(Player player) {
		if (player.victoryStatus) {
			System.out.println("Congratulations, " + player.name + "! You have won the game");
		}
	}
}
