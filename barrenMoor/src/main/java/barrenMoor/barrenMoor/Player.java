package barrenMoor.barrenMoor;

public class Player {
	String name;
	int score;
	boolean victoryStatus;
		public Player(String name, int score, boolean victoryStatus) {
			this.score = score;
			this.victoryStatus = victoryStatus;
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
		public boolean isVictoryStatus() {
			return victoryStatus;
		}
		public void setVictoryStatus(boolean victoryStatus) {
			this.victoryStatus = victoryStatus;
		}
}
