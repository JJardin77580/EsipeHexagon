package Pionnieers;


import java.util.ArrayList;
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
	private static ArrayList<Jeton> jetons;
	
	public static void main(String[] args) {
		HexaGrid<DataHexagon> hexagonGrid=new HexaGrid<>(min,min, max, max);
		HexagonRender render=new HexagonRender(30);
		HexaGridView<DataHexagon> hexagridview= new HexaGridView<>(hexagonGrid,render);
		jetons = new ArrayList<Jeton>();
		initJetons();
		GenerateTerrain terrain = new GenerateTerrain();

		int lim=0;
		int incr=1;
		for (int q=min;q<=max;q++) {
			for (int r = min; r <=max; r++) {
				lim=q+r;
				DataHexagon data = new DataHexagon();
				if((q==min)||(q==max)||(r==min)||(r==max)||(lim==max)||(lim==min)){
					data.setType(TypeHex.SEA);
				} else if((lim>=hexagonGrid.getMinQ())&&(lim<=hexagonGrid.getMaxQ())){
					System.out.println(incr);
					incr++;
					int getCase = terrain.getCase();
					data.setType(TypeHex.values()[getCase]);
					if(TypeHex.values()[getCase] != TypeHex.DESERT)
						data.setJeton(getJeton());
				}
				hexagonGrid.setData(q, r,data);
				hexagridview.addHexagonView(q, r, new HexagonPanel());
			}
		}
		Fenetre f=new Fenetre(hexagridview,hexagonGrid);
	}

	
	private static int getJeton() {
		if(jetons.size() < 0)
			throw new IndexOutOfBoundsException();
		Random rand = new Random();
		int index = rand.nextInt(jetons.size());
		if(jetons.get(index).getNombre() >= 1)
			jetons.get(index).removeOne();
		else
			jetons.remove(index);
		return index;
	}

	private static void initJetons() {
		int quantité=1;
		for(int nombre = 1 ; nombre < 13 ; nombre++){
			if(nombre == 1 || nombre == 12)
				quantité = 1;
			else
				quantité = 2;
			jetons.add(new Jeton(quantité,nombre));
		}
	}

}


/**
 * 
 * TO-DO
 * 
 * ajouter les ports a l'aléatoire
 * Dirty method jeton
 * Implémentation des classes Road, town, colony
 * 
 * 
 * 
 * 
 **/