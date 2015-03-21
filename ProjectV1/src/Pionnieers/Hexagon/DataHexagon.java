package Pionnieers.Hexagon;

import java.awt.Color;


public class DataHexagon {
	private Color color;
	private int type;
	private int jeton;

	public enum TypeHex {FOREST(4), PASTURE(4), FARMLAND(4), HILL(3), MOUNTAIN(3),DESERT(1), MARINA(9), SEA(4);
		private final int capacity;

		TypeHex(int capacity){this.capacity = capacity;}
		public int getCapacity(){return this.capacity;}
	
	};

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
	
	public void setJeton(Integer jeton){
		this.jeton = jeton;
	}
	public int getJeton(){
		return jeton;
	}

	public int getType() {
		return type;
	}

	public Color getColor() {
		return color;
	}



}
