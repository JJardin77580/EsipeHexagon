package GelWar;

import hexalib.Coordinates;
import hexalib.Hexalib;
import hexalib.Hexalib.HexagonView;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Plateau extends JPanel implements MouseListener{
	private final Hexalib.HexaGridView<Integer> hexagridView;

	public Plateau( Hexalib.HexaGridView<Integer> hexagrid)
	{
		this.hexagridView=hexagrid;
		setBackground(Color.WHITE);
	} 
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g; 
		super.paintComponent(g2);
		hexagridView.DrawGrid(g2);

	}


	@Override
	public void mouseClicked(MouseEvent e) {
	
			int x = e.getX();
			int y = e.getY();
			System.out.println(hexagridView.getDataForPixel(x-Fenetre.offsetX, y-Fenetre.offsetY));
			int s=30;
			Coordinates c=Hexalib.PixelToCube(x-Fenetre.offsetX,y-Fenetre.offsetY,s);
			hexagridView.getHexagonView(c.q,c.r).setColor(Color.red);
			System.out.println("q= "+ c.q + "r= "+ c.r);
			repaint();
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
