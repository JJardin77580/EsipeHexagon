package Pionnieers.Hexagon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.HashMap;

import hexalib.Hexalib.Direction;
import hexalib.Hexalib.HexagonView;
import hexalib.Point;
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

	@Override
	public Color getEdgeColor(Direction edge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDataString(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCenter(Point center) {
		// TODO Auto-generated method stub
		
	}

}