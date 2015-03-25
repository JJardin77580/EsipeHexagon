package GelWar;

import java.awt.Color;

public class Player {
	private final String name;
	private final Color color;
	private int compteurmiroir=6;

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


	public int getCompteurmiroir() {
		return compteurmiroir;
	}


	public void setCompteurmiroir(int compteurmiroir) {
		this.compteurmiroir = compteurmiroir;
	}



}
