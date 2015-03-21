package Pionnieers.Player;

import java.awt.Color;
import java.util.ArrayList;

public class Player {
	private final String name;
	private final Color color;
	private ArrayList<Road> road;
	private ArrayList<Town> town;
	private ArrayList<Colony> colonie;
	private int nbPoints;
	

	public Player(String name, Color color) {
		this.name=name;
		this.color=color;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public int getNbPoints(){
		return nbPoints;
	}
	
	

}
