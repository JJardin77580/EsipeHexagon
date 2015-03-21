package Pionnieers;

import hexalib.Coordinates;
import hexalib.HexaGrid;
import hexalib.Hexalib;
import hexalib.Hexalib.HexaGridView;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Pionnieers.Hexagon.DataHexagon;
import Pionnieers.Hexagon.DataHexagon.TypeHex;

	/**
	 * gestion des différents éléments du jeu (au niveau du plateau)
	 *  - affichage de texte
	 *  - rafraichissement de l'écran
	 *  - gesstion de la souris
	 * @author adrien
	 *
	 */
public class Plateau extends JPanel implements MouseListener{
	private static final long serialVersionUID = 1L;
	private final HexaGridView<DataHexagon> hexagridView;
	private final HexaGrid<DataHexagon> hexagrid;
	private final MenuDroite menu;

	public Plateau(HexaGridView<DataHexagon> hexaGridView,HexaGrid<DataHexagon> hexaGrid)
	{
		this.hexagridView=hexaGridView;
		this.hexagrid=hexaGrid;
		setBackground(Color.WHITE);
		menu = new MenuDroite();
	}
	
	
	public int tirageDe(){
		Random rand = new Random();
		return rand.nextInt(6)+1;
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g; 
		super.paintComponent(g2);
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		hexagridView.DrawGrid(g2);
		menu.afficherMenu(g);
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)){
			int x = e.getX();
			int y = e.getY()-30;
			int s=30;
			Coordinates c=Hexalib.PixelToCube(x-Fenetre.offsetX,y-Fenetre.offsetY,s);
			DataHexagon p1= new DataHexagon();
			p1.setType(TypeHex.MOUNTAIN);
			hexagrid.setData(c.q, c.r, p1);
			System.out.println("q= "+ c.q + "r= "+ c.r);
			menu.HUD();
		}
		if(SwingUtilities.isRightMouseButton(e)){
			System.out.println(tirageDe());
			
		}
		
		repaint();
	}
	
	@Override public void mousePressed(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
}
