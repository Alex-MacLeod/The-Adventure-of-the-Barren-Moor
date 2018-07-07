package game.player;

public class Player {
	public String name;
	public int score;
	public boolean victory;
		public Player(String name, int score, boolean victory) {
			this.score = score;
			this.victory = victory;
			this.name = name;
		}
	public boolean isVictory() {
			return victory;
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
