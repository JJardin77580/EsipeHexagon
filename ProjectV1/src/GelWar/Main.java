package GelWar;

import java.awt.Color;

import GoleConquest.Player;
import GoleConquest.Hexagon.DataHexagon;
import hexalib.HexaGrid;
import hexalib.HexagonPanel;
import hexalib.Hexalib.HexaGridView;
import hexalib.Hexalib.HexagonView;

public class Main {
		
	public static void main(String[] args) {
		
		HexaGrid<DataHexagon> hexaGrid=new HexaGrid<>(-3, -3, 3, 3);
		HexagonRender render=new HexagonRender();
		render.setSize(30);
		
		HexaGridView<DataHexagon> hexagridview= new HexaGridView<>(hexaGrid,render);
		int i=0;
		int lim=0;
		Player p=new Player("coucou", Color.GREEN);
		for (int q=-3;q<=3;q++) {
			for (int r = -3; r <=3; r++) {
				lim=q+r;
				if((lim>=hexaGrid.getMinQ())&&(lim<=hexaGrid.getMaxQ())){
				DataHexagon data = new DataHexagon(i,p);
				hexaGrid.setData(q, r,data);
				i++;
				hexagridview.addHexagonView(q, r, new HexagonPanel());
			}}
			
		}
		Fenetre f=new Fenetre(hexagridview,hexaGrid);
	}

}
