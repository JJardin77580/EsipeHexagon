package GelWar;

public class DataHexagon {
	private Integer score;
	private Player player;

	public DataHexagon(int score,Player player) {
		this.setScore(score);
		this.setPlayer(player);
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
	
}