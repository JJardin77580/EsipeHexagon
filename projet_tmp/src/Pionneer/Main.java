package Pionneer;

import hexalib.HexaGrid;
import hexalib.HexagonPanel;
import hexalib.Hexalib.HexaGridView;

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
				//System.out.println( "q="+q +" r="+r);
				hexagonGrid.setData(q, r,i);
				i++;
				hexagridView.addHexagonView(q, r, new HexagonPanel());
			}
			
		}
		Fenetre f=new Fenetre(hexagridView);

	}

}
