package Pioneers.Hexagon;

import hexalib.Hexalib.Direction;
import hexalib.Hexalib.HexagonView;
import hexalib.Point;

import java.awt.Color;
import java.awt.Graphics2D;


public class DataHexagon implements HexagonView{
	private Color color;
	private int type;
	private int jeton;
	private Color[] edgeColor;
	private int direction;

	public enum TypeHex {FOREST(4), PASTURE(4), FARMLAND(4), HILL(3), MOUNTAIN(3),DESERT(1), MARINA(9), SEA(4);
	private final int capacity;

	TypeHex(int capacity){this.capacity = capacity;}
	public int getCapacity(){return this.capacity;}
	};

	public DataHexagon() {
		edgeColor = new Color[6];
		for(int i = 0 ; i < edgeColor.length ; i++)
			edgeColor[i] = Color.black;
		direction = 0;
	}

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
	
	public void setDirection(Direction dir) {
		direction = dir.ordinal();
	}
	
	public void setEdgeColor(Color[] color) {
		this.edgeColor = color;
	}
	
	public Color[] getAllEdgeColor() {
		return edgeColor;
	}
	
	public void setOneEdgeColor(Color color) {
		edgeColor[direction] = color;
	}
	@Override
	public void setEdge(Direction edge, Color color) {
		
	}
	
	@Override 
	public Color getEdgeColor(Direction edge) {
		return edgeColor[edge.ordinal()];
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
	
	public void setColor(Color color){
		this.color = color;
	}



	
	
	@Override public void setCx(int... cx) {}
	@Override public void setCy(int... cy) {}
	@Override public void drawHex(Graphics2D g2) {}
	@Override public void setDataString(String s) {}
	@Override public void setCenter(Point center) {}
	@Override public void drawPoint(Graphics2D g2, int x, int y, Color c) {}




}
