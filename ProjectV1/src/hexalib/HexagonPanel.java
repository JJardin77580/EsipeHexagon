package hexalib;

import hexalib.Hexalib.Direction;
import hexalib.Hexalib.HexagonView;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
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
	public Color getEdgeColot(Direction edge) {
		return this.colorEdge.get(edge);
	}
	public void drawHex(Graphics2D g2) {
		Polygon poly = new Polygon(cx,cy,6);
		g2.setColor(this.color);
		g2.fillPolygon(poly);
		//g2.setColor(this.color);
		g2.setColor(Color.BLACK);
		g2.drawPolygon(poly);
		if((center!=null)&&(dataString!=null)){
			g2.setFont(new Font("arial",1 , 20));
			g2.drawString(dataString, (int)center.x,(int)center.y);
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

	

}
