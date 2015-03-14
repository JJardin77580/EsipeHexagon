package GelWar;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.HashMap;

import hexalib.Hexalib.Direction;
import hexalib.Hexalib.HexagonView;

public class HexagonPanel implements HexagonView {

	private  Color color;
	private int size;
	private HashMap<Direction, Color> colorEdge= new HashMap<>();
	private int cx[];
	private int cy[];
	@Override
	public void setColor(Color color) {
		this.color=color;
	}

	public void setCx( int ... cx){
		this.cx=cx;

	}
	public void setCy(int ... cy){
		this.cy=cy;
	}
	@Override
	public void setEdge(Direction edge, Color color) {
		colorEdge.put(edge, color);

	}

	@Override
	public void setSize(int size) {
		this.size=size;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public Color getEdgeColor(Direction edge) {
		return this.colorEdge.get(edge);
	}

	@Override
	public int getSize() {
		return this.size;
	}

	public void drawHex(Graphics2D g2) {
		Polygon poly = new Polygon(cx,cy,6);
		g2.setColor(this.color);
		g2.fillPolygon(poly);
		//g2.setColor(this.color);
		//g2.drawPolygon(poly);
	} 

}
