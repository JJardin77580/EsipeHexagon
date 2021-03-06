package Pionneer.Hexagon;

import Pionneer.Fenetre;
import hexalib.Coordinates;
import hexalib.Hexalib.HexagonRenderer;
import hexalib.Hexalib.HexagonView;
/**
 * Gère l'affichage d'un hexagone
 * @author adrien
 *
 * @param <T>
 */
public class HexagonRender<T> implements HexagonRenderer<T> {
	private final int hexagonSize;
	private int offsetX;
	private int offsetY;
	
	public HexagonRender(int hexagonSize) {
		this.hexagonSize=hexagonSize;
	}
	
	public Coordinates hex_corner(int x,int y, int size, int i){
		double angle_deg = 60 * i  ;
		double angle_rad =  Math.toRadians(angle_deg);
		return new Coordinates ((int)(x + size * Math.cos(angle_rad)),
				(int ) (y + size * Math.sin(angle_rad)));
	}
	@Override
	public void render(int q, int r, T data, HexagonView hexagonView) {

		if(hexagonSize<=0)
			throw new IllegalStateException("size is nul or negative");
		int s=hexagonSize;
		int width=s*2;
		int height=(int) (Math.sqrt(3)/2.0*width);
		int x;
		int y;
		 x = (int) (3.0/4 *width*q);
		 y= (int) (1.0/2.0 * height *q +height*r);
		 x+=Fenetre.offsetX;
		 y+=Fenetre.offsetY;
		int[] cx,cy;
		cx=new int[6];
		cy=new int[6];
		for (int i=0;i<6;i++){
			Coordinates c=hex_corner(x, y, hexagonSize, i);
			cx[i]=c.getx();
			cy[i]=c.gety();
		}
		hexagonView.setCx(cx);
		hexagonView.setCy(cy);
	}
	
	@Override
	public int getsize() {
		return hexagonSize;
	}

	public void setBorderX(int offsetX) {
		this.offsetX=offsetX;
		
	}

	public void setBorderY(int offsetY) {
		this.offsetY=offsetY;
		
	}
	
	

}
