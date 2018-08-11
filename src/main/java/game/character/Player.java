package game.character;

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
}
