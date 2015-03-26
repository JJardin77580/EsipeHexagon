package GelWar;

import java.awt.Color;

import hexalib.Coordinates;
import hexalib.Hexalib.Direction;
import hexalib.Hexalib.HexagonRenderer;
import hexalib.Hexalib.HexagonView;
import hexalib.Point;

public class HexagonRender implements HexagonRenderer<DataHexagon> {
	private int size;	
	public void setSize(int size){
		this.size=size;
	}
	
	public Coordinates hex_corner(int x,int y, int size, int i){
		double angle_deg = 60 * i  ;
		double angle_rad =  Math.toRadians(angle_deg);
		return new Coordinates ((int)(x + size * Math.cos(angle_rad)),
				(int ) (y + size * Math.sin(angle_rad)));
	}
	@Override
	public void render(int q, int r, DataHexagon data, HexagonView hexagonView) {

		if(size<=0)
			throw new IllegalStateException("size is nul or negative");
		int s=size;
		int width=s*2;
		int height=(int) (Math.sqrt(3)/2.0*width);
		int x;
		int y;
		 x = (int) (3.0/4.0 *width*q);
		 y= (int) (1.0/2.0 * height *q +height*r);
		 x+=Fenetre.offsetX;
		 y+=Fenetre.offsetY;
		int[] cx,cy;
		cx=new int[6];
		cy=new int[6];
		for (int i=0;i<6;i++){
			Coordinates c=hex_corner(x, y, size, i);
			cx[i]=c.getx();
			cy[i]=c.gety();
		}
		hexagonView.setCx(cx);
		hexagonView.setCy(cy);
		hexagonView.setCenter(new Point(x, y, 0));
		hexagonView.setColor(data.getPlayer().getColor());
		hexagonView.setDataString((data.getScore().toString()));
		for (Direction direction : data.getMirrors()) {
			hexagonView.setEdge(direction, Color.red);
		}
	}
	
	@Override
	public int getsize() {
		return size;
	}



	
	

}
