package game.character;

import game.manager.Location;
import game.util.Input;

import java.util.Objects;

public class Player extends Character{

	private int score;
    private boolean victorious;

	public Player(String name) {
	    super(name);
		this.score = 0;
		this.victorious = false;
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
                        System.out.println("The compass is pointing " + Location.findDirection().getLowercase() + ".");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return score == player.score && victorious == player.victorious;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, victorious);
    }
}
