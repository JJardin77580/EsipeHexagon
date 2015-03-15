package Pionneer;

import java.util.Random;

import hexalib.HexaGrid;
import hexalib.Hexalib.HexaGridView;

import Pionneer.Hexagon.Hexagon;
import Pionneer.Hexagon.HexagonRender;
import Pionneer.Hexagon.Hexagon.HexagonType;


public class Main {

	public static void main(String[] args) {
		//création d'une grile comprenant des hexagones
		HexaGrid<Integer> hexagonGrid=new HexaGrid<>(0, 0, 7, 7);
		//gestion de l'hexagone (son rendu visuel)
		HexagonRender<Integer> render=new HexagonRender<>(30);
		HexaGridView<Integer> hexagridView= new HexaGridView<>(hexagonGrid,render);
		
		int i=0;
		for (int q=0;q<=7;q++) {
			for (int r = 0; r <=7; r++) {
				hexagonGrid.setData(q, r,i);
				i++;
				Random rand = new Random();
				int nb = rand.nextInt(8);
				Hexagon hexPan = new Hexagon(HexagonType.values()[nb]);
				hexagridView.addHexagonView(q, r, hexPan);
			}
		}
		Fenetre f=new Fenetre(hexagridView);
	}

}
