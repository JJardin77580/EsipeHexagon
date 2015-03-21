package GelWar;

import java.awt.Color;

public class Player {
	private final String name;
	private final Color color;

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
	
	

}
