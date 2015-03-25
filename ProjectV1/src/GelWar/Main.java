package GelWar;
import java.awt.Color;
import java.util.Random;

import hexalib.HexaGrid;
import hexalib.HexagonPanel;
import hexalib.Hexalib.HexaGridView;


public class Main {

	public static void main(String[] args) {

		HexaGrid<DataHexagon> hexaGrid=new HexaGrid<>(-5, -5, 5, 5);
		HexagonRender render=new HexagonRender();
		render.setSize(30);
		HexaGridView<DataHexagon> hexagridview= new HexaGridView<>(hexaGrid,render);
		int lim=0;
		Player p=new Player("Player1", Color.GREEN);
		Player p2=new Player("Player2", Color.ORANGE);
		Player p3=new Player("Player3", Color.BLUE);
		Player [] players = new Player[3];
		players[0]=p;
		players[1]=p2;
		players[2]=p3;
		hexaGrid.addObserver((q,r)->{
			render.render(q, r, hexaGrid.getData(q, r),hexagridview.getHexagonView(q, r) );
		});
		
		int minscore=1;
		int maxscore=15;
		Random rand = new Random();	
		for (int q=-5;q<=5;q++) {
			for (int r = -5; r <=5; r++) {
				lim=q+r;
				if((lim>=hexaGrid.getMinQ())&&(lim<=hexaGrid.getMaxQ())){
					int nombreAleatoire = rand.nextInt(2 - 0 + 1) + 0;
					int score=rand.nextInt(maxscore-minscore+1)+minscore;
					Player current=players[nombreAleatoire];
					DataHexagon data = new DataHexagon(score,current);
					hexaGrid.setData(q, r,data);
					hexagridview.addHexagonView(q, r, new HexagonPanel());

				}}

		}
		@SuppressWarnings("unused")
		Fenetre f=new Fenetre(hexagridview,hexaGrid,players);
	}

}
