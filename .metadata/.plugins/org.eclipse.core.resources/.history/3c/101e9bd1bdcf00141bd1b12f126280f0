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
	public Plateau( HexaGridView<DataHexagon> hexaGridView,HexaGrid<DataHexagon> hexaGrid)
	{
		this.hexagridView=hexaGridView;
		this.hexagrid=hexaGrid;
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
			int y = e.getY()-30;
			//System.out.println(hexagridView.getDataForPixel(x-Fenetre.offsetX, y-Fenetre.offsetY));
			int s=30;
			Coordinates c=Hexalib.PixelToCube(x-Fenetre.offsetX,y-Fenetre.offsetY,s);
			DataHexagon p2= new DataHexagon(0,new Player("coucou2", Color.CYAN));
			hexagrid.setData(c.q, c.r, p2);
			//hexagridView.getModel().setData(q, c.r, p2);
			//hexagridView.getHexagonView(c.q,c.r).setColor(Color.red);
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
