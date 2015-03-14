package Pionneer;

import hexalib.Hexalib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Plateau extends JPanel implements MouseListener{
	private final Hexalib.HexaGridView<Integer> hexagridView;
	private final int hexagonSize;
	
	public enum hexagonType {
		FOREST, PASTURE, FARMLAND, HILL, MOUNTAIN,DESERT, MARINA, SEA
		
		
	;}

	public Plateau(Hexalib.HexaGridView<Integer> hexagrid, int hexagonSize)
	{
		this.hexagonSize = hexagonSize;
		this.hexagridView=hexagrid;
		setBackground(Color.BLUE);
	}
	
	/**
	 * Permet de générer un terrain aléatoirement en fonction des ressources disponnibles
	 * @return le terrain généré
	 */
	public void GenerateTerrain(){
		
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g; 
		super.paintComponent(g2);
		hexagridView.DrawGrid(g2);

	}


	@Override
	public void mouseClicked(MouseEvent e) {

	}
	
	@Override public void mousePressed(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
}
