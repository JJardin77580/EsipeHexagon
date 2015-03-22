package hexalib;

import hexalib.Hexalib.Direction;
import hexalib.Hexalib.HexagonView;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Stroke;
import java.util.HashMap;

public class HexagonPanel implements HexagonView {
	private  Color color=Color.blue;
	private HashMap<Direction, Color> colorEdge= new HashMap<>();
	private int cx[];
	private int cy[];
	private Point center;
	private String dataString;
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
	public Color getColor() {
		return this.color;
	}
	@Override
	public Color getEdgeColor(Direction edge) {
		return this.colorEdge.get(edge);
	}
	public void drawHex(Graphics2D g2) {
		Polygon poly = new Polygon(cx,cy,6);
		g2.setColor(this.color);
		g2.fillPolygon(poly);
		g2.setColor(Color.BLACK);
		Stroke init = g2.getStroke();
		//g2.drawPolygon(poly);
		for (Direction d : Direction.values()) {
			g2.setColor(Color.BLACK);
			Color colorEgde=getEdgeColor(d);
			g2.setStroke(new BasicStroke(3));
			if(colorEgde!=null){
				g2.setColor(colorEgde);
			}
			switch(d) {
			case NORTH:
				g2.drawLine(cx[4], cy[4], cx[5], cy[5]);
			case NORTH_EAST:
				g2.drawLine(cx[5], cy[5], cx[0], cy[0]);
			case SOUTH_EAST:
				g2.drawLine(cx[0], cy[0], cx[1], cy[1]);
			case SOUTH:
				g2.drawLine(cx[1], cy[1], cx[2], cy[2]);
			case SOUTH_WEST:
				g2.drawLine(cx[2], cy[2], cx[3], cy[3]);
			case NORTH_WEST:
				g2.drawLine(cx[3], cy[3], cx[4], cy[4]);
			}
		}
		if((center!=null)&&(dataString!=null)){
			g2.setFont(new Font("arial",1 , 20));
			g2.drawString(dataString, (int)center.x-7,(int)center.y);
		}
	}

	
	@Override
	public void setDataString(String s) {
		this.dataString=s;
	}
	
	@Override
	public void setCenter(Point center) {
		this.center=center;	
	}

	@Override
	public void drawPoint(Graphics2D g2, int x, int y, Color c) {
	g2.setColor(c);
	g2.drawOval(cx[x], cy[y], 5, 5);
	}



}
