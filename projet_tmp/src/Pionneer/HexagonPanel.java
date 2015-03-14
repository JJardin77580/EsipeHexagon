package Pionneer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.HashMap;

import Pionneer.Plateau.hexagonType;

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
public class HexagonPanel implements HexagonView{
	private Color color;
	private final int size;
	private final int type;
	private final boolean valid;
	//j'ai pas trop colmpris...
	private HashMap<Direction, Color> colorEdge= new HashMap<>();
	private int cx[];
	private int cy[];
	
	public HexagonPanel(int size, int type, boolean valid) {
		this.size = size;
		this.type = type;
		if(type == hexagonType.SEA.ordinal())
			this.valid = false;
		else
			this.valid = valid;
		
			
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
	}

}
