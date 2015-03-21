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
	private final ArrayList<Jeton> jetons;
	private final MenuDroite menu;
	private Random rand;

	public Plateau(HexaGridView<DataHexagon> hexaGridView,HexaGrid<DataHexagon> hexaGrid)
	{
		this.hexagridView=hexaGridView;
		this.hexagrid=hexaGrid;
		setBackground(Color.WHITE);
		menu = new MenuDroite();
		jetons = new ArrayList<Jeton>();
		int quantité=1;
		for(int nombre = 1 ; nombre < 13 ; nombre++){
			if(nombre == 1 || nombre == 12)
				quantité = 1;
			else
				quantité = 2;
			jetons.add(new Jeton(quantité,nombre));
		}
	}
	
	
	public int tirageDe(){
		return rand.nextInt(6)+1;
	}
	
	public int getJeton(){
		if(jetons.size() < 0)
			throw new IllegalStateException();
		int index = rand.nextInt(jetons.size());
		if(jetons.get(index).getNombre() >= 1)
			jetons.get(index).removeOne();
		else
			jetons.remove(index);
		return index;
		
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
		int x = e.getX();
		int y = e.getY()-30;
		//System.out.println(hexagridView.getDataForPixel(x-Fenetre.offsetX, y-Fenetre.offsetY));
		int s=30;
		Coordinates c=Hexalib.PixelToCube(x-Fenetre.offsetX,y-Fenetre.offsetY,s);
		DataHexagon p1= new DataHexagon();
		p1.setType(TypeHex.MOUNTAIN);
		hexagrid.setData(c.q, c.r, p1);
		//hexagridView.getModel().setData(q, c.r, p2);
		//hexagridView.getHexagonView(c.q,c.r).setColor(Color.red);
		System.out.println("q= "+ c.q + "r= "+ c.r);
		menu.HUD();
		tirageDe();//doit normalement se faire avec un clic sur un bouton
		repaint();
	}
	
	@Override public void mousePressed(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
}
