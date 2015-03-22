package GelWar;

import hexalib.Hexalib;
import hexalib.Hexalib.Direction;

import java.util.ArrayList;
import java.util.List;



public class DataHexagon {
	private Integer score;
	private Player player;
	private List<Direction> mirrors;
	
	public DataHexagon(int score,Player player) {
		this.setScore(score);
		this.setPlayer(player);
		this.mirrors=new ArrayList<Hexalib.Direction>();
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

