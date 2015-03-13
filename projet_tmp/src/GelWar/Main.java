package GelWar;

import java.awt.Color;

import hexalib.HexaGrid;
import hexalib.HexagonPanel;
import hexalib.Hexalib.HexaGridView;
import hexalib.Hexalib.HexagonView;

public class Main {
		
	public static void main(String[] args) {
		
		HexaGrid<Integer> hexaGrid=new HexaGrid<>(0, 0, 10, 10);
		HexagonRender<Integer> render=new HexagonRender<>();
		render.setSize(30);
		HexaGridView<Integer> hexagridview= new HexaGridView<>(hexaGrid,render);
		int i=0;
		for (int q=0;q<=10;q++) {
			for (int r = 0; r <=10; r++) {
				hexaGrid.setData(q, r,i);
				i++;
				hexagridview.addHexagonView(q, r, new HexagonPanel());
				
			}
			
		}
		Fenetre f=new Fenetre(hexagridview);
	}

}
