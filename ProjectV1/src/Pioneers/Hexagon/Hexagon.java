package Pioneers.Hexagon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.HashMap;

import hexalib.Hexalib.Direction;
import hexalib.Hexalib.HexagonView;
import hexalib.Point;

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
		g2.setColor(Color.black);
		g2.drawPolygon(poly);
	}
	@Override public Color getEdgeColor(Direction edge) {return null;}
	@Override public void setDataString(String s) {}
	@Override public void setCenter(Point center) {}
	@Override public void drawPoint(Graphics2D g2, int x, int y, Color c) {}



}
