package GelWar;
import hexalib.Coordinates;
import hexalib.HexaGrid;
import hexalib.Hexalib;
import hexalib.Hexalib.HexaGridView;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Plateau extends JPanel implements MouseListener{
	private final HexaGridView<DataHexagon> hexagridView;
	private final HexaGrid<DataHexagon> hexagrid;
	private final Player[] players;
	private int currentplayer=0;

	public Plateau( HexaGridView<DataHexagon> hexaGridView,HexaGrid<DataHexagon> hexaGrid, Player[] players)
	{
		this.hexagridView=hexaGridView;
		this.hexagrid=hexaGrid;
		setBackground(Color.WHITE);
		this.players=players;

	} 

	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g; 
		super.paintComponent(g2);
		hexagridView.DrawGrid(g2);
		g2.setColor(this.players[currentplayer].getColor());
		g2.drawString("Tour de " +this.players[currentplayer].getName(), 425, 100);
	}


	@Override
	public void mouseClicked(MouseEvent e) {

		int s=30;
		int x = e.getX();
		int y = e.getY()-s;
		Coordinates c=Hexalib.PixelToCube(x-Fenetre.offsetX,y-Fenetre.offsetY,s);
		if(players[currentplayer].getName()==hexagrid.getData(c.q, c.r).getPlayer().getName()){
			System.out.println(players[currentplayer].getName());
			hexagrid.notifyAllObserver(c.q, c.r);
			System.out.println("q= "+ c.q + "r= "+ c.r);
			repaint();

			if(currentplayer==players.length-1){
				currentplayer=0;
			}
			else {
				currentplayer++;
			}

		}

	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


}
