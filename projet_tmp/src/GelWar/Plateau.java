package GelWar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class Plateau extends JPanel {
	final static int BSIZE = 5;
	public Plateau()
	{
		setBackground(Color.BLACK);
	} 

	public void paintComponent(Graphics g){

		Graphics2D g2 = (Graphics2D)g; 
		super.paintComponent(g2);
		for (int i=0;i<BSIZE;i++) {
			for (int j=0;j<BSIZE;j++) {
				HexagonPanel panelHexa= new HexagonPanel();
				panelHexa.setColor(Color.blue);
				panelHexa.setSize(60);
				HexagonRender<Integer> hexa=new HexagonRender<>();
				hexa.render(i, j,0, panelHexa);
				panelHexa.drawHex(g2);
				
			}
		} 



	}


}
