package GelWar;

import hexalib.Hexalib.HexagonRenderer;
import hexalib.Hexalib.HexagonView;

public class HexagonRender<T> implements HexagonRenderer<T> {

	@Override
	public void render(int q, int r, T data, HexagonView hexagonView) {
		if(hexagonView.getSize()<=0)
			throw new IllegalStateException("size is nul or negative");
		int s=hexagonView.getSize();
		int w = (int) ( s/2);
		int radius =  (int) (s * 0.8660254037844);
		int h=2*radius;
		int x=q*(s+w);
		int y=r*h+(q%2)*h/2;
		x+=15;
		y+=15;
		int[] cx,cy;
		cx = new int[] {x+w,x+s+w,x+s+2*w,x+s+w,x+w,x};	
		cy = new int[] {y,y,y+radius,y+2*radius,y+2*radius,y+radius};
		hexagonView.setCx(cx);
		hexagonView.setCy(cy);
		
		
		
	}

}
