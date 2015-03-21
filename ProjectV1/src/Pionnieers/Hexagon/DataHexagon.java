package Pionnieers.Hexagon;

import java.awt.Color;


public class DataHexagon {
	private Color color;
	private int type;
	private int jeton;

	public enum TypeHex {FOREST, PASTURE, FARMLAND, HILL, MOUNTAIN,DESERT, MARINA, SEA;};



	public void setType(TypeHex type){
		this.type = type.ordinal();
		switch(type){
		case FOREST:   color = Color.green; break;
		case PASTURE:  color = Color.green.darker(); break;
		case FARMLAND: color = Color.orange.darker().darker(); break;
		case HILL:     color = Color.magenta; break;
		case MOUNTAIN: color = Color.white; break;
		case DESERT:   color = Color.yellow; break;
		case MARINA:   color = Color.cyan; break;
		case SEA:      color = Color.blue; break;
		}
	}
	
	public void setJeton(int jeton){
		this.jeton = jeton;
	}

	public int getType() {
		return type;
	}

	public Color getColor() {
		return color;
	}



}