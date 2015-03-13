package GelWar;

import hexalib.Coordinates;
import hexalib.Hexalib.HexagonRenderer;
import hexalib.Hexalib.HexagonView;

public class HexagonRender<T> implements HexagonRenderer<T> {
	int size;
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
	public void render(int q, int r, T data, HexagonView hexagonView) {

		if(size<=0)
			throw new IllegalStateException("size is nul or negative");
		int s=size;
		int radius =  (int) (s * 0.8660254037844);
		int x;
		int y;
		x = radius * 3/2 * q;
		y = (int) (radius * Math.sqrt(3) * (r - 0.5 * (q&1)));
		x+=50;
		y+=50;
		int[] cx,cy;
		cx=new int[6];
		cy=new int[6];
		for (int i=0;i<6;i++){
			Coordinates c=hex_corner(x, y, radius, i);
			cx[i]=c.getx();
			cy[i]=c.gety();
		}
		//cx = new int[] {x+w,x+s+w,x+s+2*w,x+s+w,x+w,x};	
		//cy = new int[] {y,y,y+radius,y+2*radius,y+2*radius,y+radius};
		hexagonView.setCx(cx);
		hexagonView.setCy(cy);
	}
	
	@Override
	public int getsize() {
		// TODO Auto-generated method stub
		return size;
	}

}
