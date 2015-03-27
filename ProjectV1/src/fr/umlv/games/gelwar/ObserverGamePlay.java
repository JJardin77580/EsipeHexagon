package fr.umlv.games.gelwar;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import hexalib.Coordinates;
import hexalib.HexaGrid;
import hexalib.Hexalib.Direction;
import hexalib.Hexalib.ModelObserver;

public class ObserverGamePlay implements ModelObserver {

	private final HexaGrid<DataHexagon> hexaGrid;
	private final Player playersuisse=new Player("Suisse", Color.WHITE);
	public ObserverGamePlay(HexaGrid<DataHexagon> hexaGrid) {
		this.hexaGrid=hexaGrid;
	}

	@Override
	public void dataChanged(int q, int r) {
		
		DataHexagon data=hexaGrid.getData(q, r);
		int score=data.getScore();
		int numbervoisines=0;
		int givescore=0;
		List<Coordinates> coordinates=new ArrayList<Coordinates>();
		for (Direction direction : Direction.values()) {
			System.out.println(direction.toString());
			int qvoisine=direction.neighborQ(q,r);
			int rvoisine=direction.neighborR(q,r);
			if((qvoisine>=hexaGrid.getMinQ())&&(qvoisine<=hexaGrid.getMaxQ())&&(rvoisine>=hexaGrid.getMinR())&&(rvoisine<=hexaGrid.getMaxR())){
				int lim=qvoisine+rvoisine;
				if((lim>=hexaGrid.getMinQ())&&(lim<=hexaGrid.getMaxQ())){
					numbervoisines++;
					System.out.println(qvoisine+" " + rvoisine);
					coordinates.add(new Coordinates(qvoisine, rvoisine));
				}
			}

		}
		givescore=(score/(numbervoisines+1));
		System.out.println(givescore);
		if(givescore>0){
			score=(score%numbervoisines)+1;
			data.setScore(score);
			this.hexaGrid.setData(q, r,data);
			for (Coordinates c : coordinates) {

				DataHexagon datacurrent=hexaGrid.getData(c.q, c.r);

				if(datacurrent.getPlayer()==data.getPlayer())
				{
					System.out.println("heure");
					datacurrent.setScore(datacurrent.getScore()+givescore);
				}

				else 
				{
					datacurrent.setScore(datacurrent.getScore()-givescore);
				}

				if(datacurrent.getScore()<0){
					datacurrent.setScore(-datacurrent.getScore());
					datacurrent.setPlayer(data.getPlayer());
				}

				if(datacurrent.getScore()==0)
				{
					datacurrent.setPlayer(playersuisse);
				}

				this.hexaGrid.setData(c.q, c.r,datacurrent );
			}

		}

	}
}


