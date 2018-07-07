package game.player;

public class Player {
	private String name;
	private int score;
	private boolean victory;

	public Player(String name) {
		this.score = 0;
		this.victory = false;
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

	public boolean isVictory() {
		return victory;
	}

	public void setVictory(boolean victory) {
		this.victory = victory;
	}

	public void scoreCheck(Player player) {
		if (player.score >= 10000) {
			player.victory = true;
			System.out.println("You now have " + player.score + " points");
		} else {
			System.out.println("You now have " + player.score + " points");
		}
	}
}
