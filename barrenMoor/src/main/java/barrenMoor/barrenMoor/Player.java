package barrenMoor.barrenMoor;

public class Player {
	String name;
	int score;
	boolean victory;
		public Player(String name, int score, boolean victory) {
			this.score = score;
			this.victory = victory;
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public void setname(String name) {
			this.name = name;
		}
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
		public boolean isVictory() {
			return victory;
		}
		public void setVictory(boolean victory) {
			this.victory = victory;
		}
}
