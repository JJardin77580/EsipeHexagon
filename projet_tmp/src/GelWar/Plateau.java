package GelWar;

import hexalib.Coordinates;
import hexalib.HexaGrid;
import hexalib.Hexalib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
public class Plateau extends JPanel implements MouseListener{
	private final int BSIZE = 6;
	private final Hexalib.HexaGridView<Integer> hexagridView;
	public Plateau( Hexalib.HexaGridView<Integer> hexagrid)
	{
		this.hexagridView=hexagrid;
		setBackground(Color.WHITE);
	} 
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g; 
		super.paintComponent(g2);
		/*for (int i=0;i<BSIZE;i++) {
			for (int j=0;j<BSIZE;j++) {
				HexagonPanel panelHexa= new HexagonPanel();
				panelHexa.setColor(Color.blue);
				panelHexa.setSize(60);
				HexagonRender<Integer> hexa=new HexagonRender<>();
				hexa.render(i, j,0, panelHexa);
				panelHexa.drawHex(g2);
			
			}
		} 
		*/
		hexagridView.DrawGrid(g2);



	}


	@Override
	public void mouseClicked(MouseEvent e) {
	
			int x = e.getX();
			int y = e.getY();
			System.out.println(hexagridView.getDataForPixel(x, y));
			int s=30;
			int radius =  (int) (s * 0.8660254037844);
			Coordinates c=Hexalib.PixelToCube(x-50,y-50,radius);
			hexagridView.getHexagonView(c.q,c.r).setColor(Color.red);
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
