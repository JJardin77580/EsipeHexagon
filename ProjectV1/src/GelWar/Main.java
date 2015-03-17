package GelWar;

import java.awt.Color;

import hexalib.HexaGrid;
import hexalib.HexagonPanel;
import hexalib.Hexalib.HexaGridView;
import hexalib.Hexalib.HexagonView;

public class Main {
		
	public static void main(String[] args) {
		
		HexaGrid<DataHexagon> hexaGrid=new HexaGrid<>(0, 0, 2, 2);
		HexagonRender render=new HexagonRender();
		render.setSize(30);
		
		HexaGridView<DataHexagon> hexagridview= new HexaGridView<>(hexaGrid,render);
		int i=0;
		Player p=new Player("coucou", Color.GREEN);
		for (int q=0;q<=2;q++) {
			for (int r = 0; r <=2; r++) {
				DataHexagon data = new DataHexagon(i,p);
				hexaGrid.setData(q, r,data);
				i++;
				hexagridview.addHexagonView(q, r, new HexagonPanel());
			}
			
		}
		Fenetre f=new Fenetre(hexagridview,hexaGrid);
	}

}
