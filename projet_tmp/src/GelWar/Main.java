package GelWar;

import java.awt.Color;

import hexalib.HexaGrid;
import hexalib.HexagonPanel;
import hexalib.Hexalib.HexaGridView;
import hexalib.Hexalib.HexagonView;

public class Main {
		
	public static void main(String[] args) {
		
		HexaGrid<Integer> hexaGrid=new HexaGrid<>(0, 0, 2, 2);
		HexagonRender<Integer> render=new HexagonRender<>();
		render.setSize(30);
		
		HexaGridView<Integer> hexagridview= new HexaGridView<>(hexaGrid,render);
		int i=0;
		for (int q=0;q<=2;q++) {
			for (int r = 0; r <=2; r++) {
				//System.out.println( "q="+q +" r="+r);
				hexaGrid.setData(q, r,i);
				i++;
				hexagridview.addHexagonView(q, r, new HexagonPanel());
			}
			
		}
		Fenetre f=new Fenetre(hexagridview);
	}

}
