package Pionnieers;


import java.util.Random;

import hexalib.HexaGrid;
import hexalib.HexagonPanel;
import hexalib.Hexalib.HexaGridView;
import Pionnieers.Hexagon.DataHexagon;
import Pionnieers.Hexagon.DataHexagon.TypeHex;
import Pionnieers.Hexagon.HexagonRender;


public class Main {
	private static int min = -3;
	private static int max =  3;
	public static void main(String[] args) {
		HexaGrid<DataHexagon> hexagonGrid=new HexaGrid<>(min,min, max, max);
		HexagonRender render=new HexagonRender(30);
		HexaGridView<DataHexagon> hexagridview= new HexaGridView<>(hexagonGrid,render);

		int lim=0;
		for (int q=min;q<=max;q++) {
			for (int r = min; r <=max; r++) {
				lim=q+r;
				DataHexagon data = new DataHexagon();
				if((q==min)||(q==max)||(r==min)||(r==max)||(lim==max)||(lim==min)){
					data.setType(TypeHex.SEA);
				} else {
					Random rand = new Random();
					data.setType(TypeHex.values()[rand.nextInt(6)]);
				}
				hexagonGrid.setData(q, r,data);
				hexagridview.addHexagonView(q, r, new HexagonPanel());
				
				
				
				/*Hexagon hexPan = new Hexagon(HexagonType.values()[nb]);
				hexagridView.addHexagonView(q, r, hexPan);*/
			}
		}
		Fenetre f=new Fenetre(hexagridview,hexagonGrid);
	}

}


/**
 * 
 * TO-DO
 * 
 * Aire de jeu aléatoire
 * 
 * 
 * 
 **/