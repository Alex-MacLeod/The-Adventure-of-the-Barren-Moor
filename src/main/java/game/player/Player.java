package game.player;

import game.manager.Location;
import game.util.Input;

public class Player {

	private final String name;
	private int score;

    private boolean victorious;

	public Player(String name) {
		this.score = 0;
		this.victorious = false;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void addPoints(int points) {
		this.score += points;
	}

	public boolean isVictorious() {
		return victorious;
	}

    public void wins() {
        this.victorious = true;
    }

    public void decideNextAction() {
        System.out.println("What are you going to do?");
        String commandInput = Input.scan.nextLine();
        String[] command = commandInput.split(" ");

        switch (command[0]) {
            case "check":
                try {
                    if ("score".equalsIgnoreCase(command[1])) {
                        System.out.println("Your current score is " + this.score);
                    } else if ("compass".equalsIgnoreCase(command[1])) {
                        System.out.println("You take a moment to check the device.");
                        System.out.println("The compass is pointing " + Location.findDirection() + ".");
                        System.out.println("The display reads: " + Location.calculateDistance() + " miles.");
                    } else {
                        System.out.println("Invalid arguments, can only check compass or score");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid arguments, must specify what you are checking: score or compass");
                }

                break;
            case "walk":
                try {
                    Location.walk(command[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid arguments, must specify a single direction: North, South, East, or West");
                }
                break;
            case "help":
                System.out.println("Valid commands: \"check\", \"walk\", \"help\"");
                break;
            default:
                System.out.println("Did not recognise command \"" + command[0] + "\". Use the \"help\" command to see list of valid commands");
                break;
        }
    }


}
