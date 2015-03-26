package Pioneers;

import java.awt.Color;

import hexalib.HexaGrid;
import hexalib.HexagonPanel;
import hexalib.Hexalib.HexaGridView;
import Pioneers.Hexagon.DataHexagon;
import Pioneers.Hexagon.HexagonRender;
import Pioneers.Hexagon.DataHexagon.TypeHex;
import Pioneers.Player.Player;


public class Main {
	private final static int min = -3;
	private final static int max =  3;


	public static void main(String[] args) {
		HexaGrid<DataHexagon> hexagonGrid=new HexaGrid<>(min,min, max, max);
		HexagonRender render=new HexagonRender(30);
		HexaGridView<DataHexagon> hexagridview= new HexaGridView<>(hexagonGrid,render);
		GenerateTerrain terrain = new GenerateTerrain();
		Tokens jeton = new Tokens();
		Player p1=new Player("Adrien (p1)", Color.RED);
		Player p2=new Player("Jeff (p2)", Color.ORANGE);
		Player [] players = new Player[2];

		jeton.init();
		terrain.initialize(TypeHex.values().length-2);// (-2) supression de la mer et de la marina
		players[0]=p1;
		players[1]=p2;
		int lim=0;

		for (int q = min ; q <= max ; q++) {
			for (int r = min; r <= max; r++) {
				lim=q+r;
				DataHexagon data = new DataHexagon();
				if((q==min)||(q==max)||(r==min)||(r==max)||(lim==min)||(lim==max)){
					data.setType(TypeHex.SEA);
				}
				else if((lim>=hexagonGrid.getMinQ())&&(lim<=hexagonGrid.getMaxQ())){
					int caseTerrain = terrain.getCase();
					data.setType(TypeHex.values()[caseTerrain]);
					if(TypeHex.values()[caseTerrain] != TypeHex.DESERT)
						data.setJeton(jeton.getJeton());
				}
				hexagonGrid.setData(q, r,data);
				hexagridview.addHexagonView(q, r, new HexagonPanel());
			}
		}
		Fenetre f=new Fenetre(hexagridview,hexagonGrid,players);
		f.setEnabled(true);
	}
}


/**
 * 
 * TO-DO
 * 
 * ajouter les ports et l'eau a l'aléatoire
 * Implémentation des classes Road, town, colony
 * construction des routes
 * construction des villes
 * 
 * 
 * 
 * 
 **/