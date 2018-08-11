package game.character;

public final class Player {

    private final String name;
	private int score;
    private boolean victorious;

	public Player(String name) {
        this.name = name;
		this.score = 0;
		this.victorious = false;
	}

    public String getName() {
        return this.name;
    }

    public int getScore() {
		return score;
	}

	public void addPoints(int points) {
	    if (points < 0) {
	        throw new IllegalArgumentException("Cannot add negative points");
        }
		this.score += points;
	}

	public boolean isVictorious() {
		return victorious;
	}

    public void wins() {
        this.victorious = true;
    }
}
