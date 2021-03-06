package Pionneer.Hexagon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.HashMap;

import hexalib.Hexalib.Direction;
import hexalib.Hexalib.HexagonView;
/**
 * Représente l'aspect visuel d'un hexagone.
 * chaque hexagone comporte :
 *  - un type (bois, montagne, etc...)
 *  - un numéro (qui sera utilisé avec les dés pour l'approvisionnement des ressources)
 * 
 * @author adrien
 *
 * @param <T>
 */
public class Hexagon implements HexagonView{
	private Color color;
	private HashMap<Direction, Color> colorEdge= new HashMap<>();
	private int cx[];
	private int cy[];
	
	private final int type;
	//public enum HexagonType {FOREST, PASTURE, FARMLAND, HILL, MOUNTAIN,DESERT, MARINA, SEA}
	public enum HexagonType {
		FOREST(4), PASTURE(4), FARMLAND(4), HILL(3), MOUNTAIN(3),DESERT(1), MARINA(9), SEA(9);
		private final int nbCase;
		
		HexagonType(int nbCase){ this.nbCase=nbCase;}
		
		public int getNbCase(){
			return nbCase;
		}
		};
	
	
	public Hexagon(HexagonType type) {
		this.type = type.ordinal();
		switch(type){
			case FOREST:   setColor(Color.green); break;
			case PASTURE:  setColor(Color.green.darker()); break;
			case FARMLAND: setColor(Color.orange.darker().darker()); break;
			case HILL:     setColor(Color.magenta); break;
			case MOUNTAIN: setColor(Color.white); break;
			case DESERT:   setColor(Color.yellow); break;
			case MARINA:   setColor(Color.cyan); break;
			case SEA:      setColor(Color.blue); break;
		}
		
	}

	@Override
	public void setColor(Color color) {
		this.color=color;

	}
	@Override
	public void setEdge(Direction edge, Color color) {
		colorEdge.put(edge, color);

	}
	@Override
	public Color getColor() {
		return this.color;
	}
	@Override
	public Color getEdgeColor(Direction edge) {
		return this.colorEdge.get(edge);
	}

	@Override public void setCx(int... cx) {this.cx=cx;}
	@Override public void setCy(int... cy) {this.cy=cy;}

	@Override
	public void drawHex(Graphics2D g2) {
		Polygon poly = new Polygon(cx,cy,6);
		g2.setColor(this.color);
		g2.fillPolygon(poly);
		g2.setColor(Color.BLACK);
		g2.drawPolygon(poly);
	}

}
