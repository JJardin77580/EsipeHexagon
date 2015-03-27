package fr.umlv.games.gelwar;

import hexalib.Hexalib;
import hexalib.Hexalib.Direction;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author jeoffrey et Adrien Garreau
 *Cette classe représente les données présentent dans les cases pour le jeu Gelwar
 */


public class DataHexagon {
	/**
	 * Représente le score présent dans la case 
	 */
	private Integer score; 
	/**
	 * Représente le joueur à qui appartient la case.
	 */
	private Player player;
	/**
	 * Représente les mirroirs.
	 */
	private List<Direction> mirrors;
	
	public DataHexagon(int score,Player player) {
		this.setScore(score);
		this.setPlayer(player);
		this.mirrors=new ArrayList<Hexalib.Direction>();
	}

	
	/**
	 * Getter sur le socre
	 * @return Score 
	 */
	public Integer getScore() {
		return score;
	}

	/**
	 * Getter sur les mirroirs
	 * @return Mirroirs
	 */
	
	public List<Direction> getMirrors(){
		return this.mirrors;
	}
	/**
	 * Ajoute un miroir
	 * @param d mirrors
	 */
	public void AddMirrors(Direction d){
		this.mirrors.add(d);
	}
	/**
	 * Setter sur le score
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Getter sur le player
	 * @return
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Setter sur le player
	 * @param player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
	
}

