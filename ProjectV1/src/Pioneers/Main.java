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
	private static int min = -3;
	private static int max =  3;

	
	public static void main(String[] args) {
		HexaGrid<DataHexagon> hexagonGrid=new HexaGrid<>(min,min, max, max);
		HexagonRender render=new HexagonRender(30);
		HexaGridView<DataHexagon> hexagridview= new HexaGridView<>(hexagonGrid,render);
		Jetons jeton = new Jetons();
		jeton.initJetons();
		GenerateTerrain terrain = new GenerateTerrain();
		Player p1=new Player("Adrien (p1)", Color.RED);
		Player p2=new Player("Jeff (p2)", Color.ORANGE);
		Player [] players = new Player[2];
		players[0]=p1;
		players[1]=p2;
		int lim=0;
		for (int q=min;q<=max;q++) {
			for (int r = min; r <=max; r++) {
				lim=q+r;
				DataHexagon data = new DataHexagon();
				if((q==min)||(q==max)||(r==min)||(r==max)||(lim==max)||(lim==min)){
					data.setType(TypeHex.SEA);
				} else if((lim>=hexagonGrid.getMinQ())&&(lim<=hexagonGrid.getMaxQ())){
					int getCase = terrain.getCase();
					data.setType(TypeHex.values()[getCase]);
					if(TypeHex.values()[getCase] != TypeHex.DESERT)
						data.setJeton(jeton.getJeton());
				}
				hexagonGrid.setData(q, r,data);
				hexagridview.addHexagonView(q, r, new HexagonPanel());
			}
		}
		Fenetre f=new Fenetre(hexagridview,hexagonGrid,players);
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
 * --------------
 * la récuperation des matièreds premières se fait en recupérant les hexagones adjecents
 * les terrains produisent uniquement via les dés
 * 
 * 
 * 
 * 
 **/