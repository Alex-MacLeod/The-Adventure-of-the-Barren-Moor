package barrenMoor.barrenMoor;

import java.util.HashMap;

public class RunGame {

	public static void main(String[] args) {
		
		Game g = new Game();
		
		System.out.println("Welcome to The Adventure of the Barren Moor");
		System.out.println("Please enter your name below:");
		String n = Input.scan.next();
		Player player = new Player(n, 0, false);
		
		Event e1 = new Treasure(5000);
		Event e2 = new Treasure(10000);
		Event e3 = new Treasure(10000);
		
		HashMap<Integer, Event> H = new HashMap<Integer, Event>();
		
		int[] point = {8, 8};
		
		g.createPoint(point);
		
		g.calculateDistance(point);
		
		g.findDirection(point);
		
		g.checkCompass(point);
		
		g.walk(point);
		
		g.startEvent(player, e1);
		
		g.scoreCheck(player);
		
		g.win(player);

	}

}
