package GelWar;

import java.awt.Color;
import java.util.Random;

import hexalib.HexaGrid;
import hexalib.HexagonPanel;
import hexalib.Hexalib.HexaGridView;
import hexalib.Hexalib.HexagonView;

public class Main {

	public static void main(String[] args) {

		HexaGrid<DataHexagon> hexaGrid=new HexaGrid<>(-4, -4, 4, 4);
		HexagonRender render=new HexagonRender();
		render.setSize(30);

		HexaGridView<DataHexagon> hexagridview= new HexaGridView<>(hexaGrid,render);
		int i=0;
		int lim=0;
		Player p=new Player("Player1", Color.GREEN);
		Player p2=new Player("Player2", Color.ORANGE);
		Player [] players = new Player[2];
		players[0]=p;
		players[1]=p2;
		hexaGrid.addObserver(new ObserverGamePlay(hexaGrid));
		int minscore=1;
		int maxscore=15;
		Random rand = new Random();	
		for (int q=-4;q<=4;q++) {
			for (int r = -4; r <=4; r++) {
				lim=q+r;
				if((lim>=hexaGrid.getMinQ())&&(lim<=hexaGrid.getMaxQ())){
					int nombreAleatoire = rand.nextInt(1 - 0 + 1) + 0;
					int score=rand.nextInt(maxscore-minscore+1)+minscore;
					Player current=players[nombreAleatoire];
					DataHexagon data = new DataHexagon(score,current);
					hexaGrid.setData(q, r,data);
					hexagridview.addHexagonView(q, r, new HexagonPanel());
				}}

		}
		Fenetre f=new Fenetre(hexagridview,hexaGrid,players);
	}

}
