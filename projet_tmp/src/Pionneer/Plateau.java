package Pionneer;

import hexalib.Hexalib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JPanel;

import Pionneer.Hexagon.Hexagon.HexagonType;

	/**
	 * gestion des différents éléments du jeu (au niveau du plateau)
	 *  - affichage de texte
	 *  - rafraichissement de l'écran
	 *  - gesstion de la souris
	 * @author adrien
	 *
	 */
public class Plateau extends JPanel implements MouseListener{
	private final Hexalib.HexaGridView<Integer> hexagridView;
	private static LinkedList<HexagonType> terrainValue;
	private final int hexagonSize;
	private final MenuDroite menu;
	
	public Plateau(Hexalib.HexaGridView<Integer> hexagrid, int hexagonSize)
	{
		this.hexagonSize = hexagonSize;
		this.hexagridView=hexagrid;
		setBackground(Color.white);
		menu = new MenuDroite();
		terrainValue = new LinkedList<HexagonType>();
		for(int i = 0 ; i < 7; i++){
			for(int j = 0 ; j < HexagonType.values()[j].getNbCase(); j++){
				terrainValue.add(HexagonType.values()[i]);
			}
		}
	}
	/**
	 * Permet de générer un terrain aléatoirement en fonction des ressources disponnibles
	 * @return le terrain généré
	 */
	public static HexagonType GenerateTerrain(){
		return null;
		/*Random rand = new Random();
		System.out.println("1");
		int nb = rand.nextInt(5/*terrainValue.size());
	/*	System.out.println("2");
		System.out.println("3");
		//terrainValue.remove(nb);
		System.out.println("4");
		return HexagonType.values()[terrainValue.get(nb).ordinal()];*/
		
		//prendre un nombre aléatoire dans une liste (prendre l'id(index))
		
	}
	
	
	public int lanceDeDes(){
		Random rand = new Random();
		int rand1 = rand.nextInt(6)+1;
		int rand2 = rand.nextInt(6)+1;
		int total = rand1+rand2;
		menu.ecrireTexte("Tirage des dés : "+ rand1 + " , " + rand2 + " --> " + total,this.getHeight()-200,this.getWidth()-50);
		
		return total;
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
		menu.HUD();
		lanceDeDes();//doit normalement se faire avec un clic sur un bouton
		repaint();
	}
	
	@Override public void mousePressed(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
}
