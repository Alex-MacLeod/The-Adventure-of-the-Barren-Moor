package game.player;

public class Player {

	private String name;
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

	public void checkScore() {
		if (this.score >= 10000) {
			this.victorious = true;
		}
		System.out.println("You now have " + this.score + " points");
	}
}
