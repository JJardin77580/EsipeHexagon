package Pioneers.Hexagon;

import Pioneers.Fenetre;
import hexalib.Coordinates;
import hexalib.Hexalib.Direction;
import hexalib.Point;
import hexalib.Hexalib.HexagonRenderer;
import hexalib.Hexalib.HexagonView;
/**
 * this class configure the display of an hexagon
 * @author adrien
 *
 */

public class HexagonRender implements HexagonRenderer<DataHexagon> {
	private int size;	
	
	public HexagonRender(int size) {
		this.size = size;
	}
	
	public Coordinates hex_corner(int x,int y, int size, int i){
		double angle_rad =  Math.toRadians(60 * i);
		return new Coordinates ((int)(x + size * Math.cos(angle_rad)),(int ) (y + size * Math.sin(angle_rad)));
	}
	
	@Override
	public int getsize() {
		return size;
	}

	@Override
	public void render(int q, int r, DataHexagon data, HexagonView hexagonView) {
		if(size<=0)
			throw new IllegalStateException("size is nul or negative");
		int width=size*2;
		int height=(int) (Math.sqrt(3)/2.0*width);
		int x = (int) (3.0/4.0 *width*q) + Fenetre.offsetX;
		int y = (int) (1.0/2.0 * height *q +height*r) + Fenetre.offsetY;
		int[] cx=new int[6];
		int[] cy=new int[6];
		
		for (int i=0;i<6;i++){
			Coordinates c=hex_corner(x, y, size, i);
			cx[i]=c.getx();
			cy[i]=c.gety();
		}
		
		hexagonView.setCx(cx);
		hexagonView.setCy(cy);
		hexagonView.setCenter(new Point(x, y, 0));
		for(int i = 0 ; i < 6 ; i++)
			hexagonView.setEdge(Direction.values()[i],data.getEdgeColor(Direction.values()[i]));
		if(data.getJeton() != 0)
			hexagonView.setDataString(String.valueOf(data.getJeton()));
		hexagonView.setColor(data.getColor());
	}
}
