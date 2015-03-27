package GelWar;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import hexalib.Coordinates;
import hexalib.HexaGrid;
import hexalib.Hexalib;
import hexalib.Hexalib.Direction;
import hexalib.Hexalib.GamePlayController;


public class ControllerGamePlayClickRight implements GamePlayController{

	private final HexaGrid<DataHexagon> hexagrid;
	private final Player playersuisse=new Player("Suisse", Color.WHITE);
	private final Player[] players;
	private int currentplayer=0;


	public ControllerGamePlayClickRight(HexaGrid<DataHexagon> hexaGrid,Player[] players) {
		this.hexagrid=hexaGrid;
		this.players=players;
	}

	public void ClickRight(int q,int r){
		DataHexagon data=hexagrid.getData(q, r);
		int score=data.getScore();
		int numbervoisines=0;
		int givescore=0;
		List<Coordinates> coordinates=new ArrayList<Coordinates>();
		for (Direction direction : Direction.values()) {
			System.out.println(direction.toString());
			int qvoisine=direction.neighborQ(q,r);
			int rvoisine=direction.neighborR(q,r);
			if((qvoisine>=hexagrid.getMinQ())&&(qvoisine<=hexagrid.getMaxQ())&&(rvoisine>=hexagrid.getMinR())&&(rvoisine<=hexagrid.getMaxR())){
				int lim=qvoisine+rvoisine;
				if(((lim>=hexagrid.getMinQ())&&(lim<=hexagrid.getMaxQ()))&&((!data.getMirrors().contains(direction)))){
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
			this.hexagrid.setData(q, r,data);
			for (Coordinates c : coordinates) {
				DataHexagon datacurrent=hexagrid.getData(c.q, c.r);
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

				this.hexagrid.setData(c.q, c.r,datacurrent );
			}
			if(currentplayer==players.length-1){
				currentplayer=0;
			}
			else {
				currentplayer++;
			}

		}



	}



	public Player getPlayer()
	{
		return players[currentplayer];
	}

	@Override
	public void dataInteracted(MouseEvent event) {

		int s=30;
		int x = event.getX();
		int y = event.getY()-s;
		Coordinates c=Hexalib.PixelToCube(x-Fenetre.offsetX,y-Fenetre.offsetY,s);
		if(players[currentplayer].getName()==hexagrid.getData(c.q, c.r).getPlayer().getName()){
			if(SwingUtilities.isLeftMouseButton(event)){
				this.ClickRight(c.q, c.r);

			}
			else {
				DataHexagon data=hexagrid.getData(c.q, c.r);
				for (Direction direction : Direction.values()) {
					int qvoisine=direction.neighborQ(c.q,c.r);
					int rvoisine=direction.neighborR(c.q,c.r);
					if((qvoisine>=hexagrid.getMinQ())&&(qvoisine<=hexagrid.getMaxQ())&&(rvoisine>=hexagrid.getMinR())&&(rvoisine<=hexagrid.getMaxR())){
						int lim=qvoisine+rvoisine;
						if((lim>=hexagrid.getMinQ())&&(lim<=hexagrid.getMaxQ())){
							if((hexagrid.getData(qvoisine, rvoisine).getPlayer()==data.getPlayer())&&(!data.getMirrors().contains(direction))){
								DataHexagon datavoisine=hexagrid.getData(qvoisine, rvoisine);
								datavoisine.AddMirrors(direction.getOpposite());
								System.out.println("here");
								data.AddMirrors(direction);
								hexagrid.setData(c.q, c.r, data);
								hexagrid.setData(qvoisine, rvoisine, datavoisine);
								break;
							}

						}


					}
				}
			}
		}
	}
}


