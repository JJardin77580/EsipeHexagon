package Pioneers;

import hexalib.Coordinates;
import hexalib.HexaGrid;
import hexalib.Hexalib;
import hexalib.Hexalib.Direction;
import hexalib.Hexalib.HexaGridView;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Pioneers.Hexagon.DataHexagon;
import Pioneers.Hexagon.DataHexagon.TypeHex;
import Pioneers.Player.Player;
import Pioneers.ToolBox.Label;

/**
 * gestion des différents éléments du jeu (au niveau du plateau)
 *  - affichage de texte
 *  - rafraichissement de l'écran
 *  - gesstion de la souris
 * @author adrien
 *
 */
public class Plateau extends JPanel implements MouseListener,KeyListener{
	private static final long serialVersionUID = 1L;
	private final HexaGridView<DataHexagon> hexagridView;
	private final HexaGrid<DataHexagon> hexagrid;
	private final MenuDroite menu;
	private final Player[] players;
	private final Label aide;

	public Plateau(HexaGridView<DataHexagon> hexaGridView,HexaGrid<DataHexagon> hexaGrid,Player[] players)
	{
		this.hexagridView=hexaGridView;
		this.hexagrid=hexaGrid;
		setBackground(Color.WHITE);
		menu = new MenuDroite();
		this.players = players;
		aide = new Label("le joueur 1 doit poser 2 colonies", 10, 20);
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
		aide.drawText(g);
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
			p1.setColor(hexagrid.getData(c.q, c.r).getColor());
			p1.setEdgeColor(Direction.NORTH, Color.YELLOW);
			hexagrid.setData(c.q, c.r, p1);
			System.out.println("q= "+ c.q + "r= "+ c.r);
		}
		if(SwingUtilities.isRightMouseButton(e)){

		}
		if(SwingUtilities.isMiddleMouseButton(e)){
			int playerActive = -1;
			for(int i = 0 ; i < players.length ; i++){
				if(players[i].isActive())
					playerActive = i;
			}
			if(playerActive == -1)
			{
				int num1 = tirageDe();
				int num2 = tirageDe();
				int total = num1 + num2;
				System.out.println("tirage des dés : " + num1 + "," + num2 + " -> " + total);
			}
			else
				System.out.println("ce n'est pas le moment de lancer les dés ! (" + players[playerActive].getName() + " joue!)");
		}
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyChar()){
		case '7':
			System.out.println(Direction.NORTH.name());
		break;
		case '9':
			System.out.println(Direction.NORTH_EAST.name());
		break;
		case '6':
			System.out.println(Direction.SOUTH_EAST.name());
		break;
		case '3':
			System.out.println(Direction.SOUTH.name());
		break;
		case '1':
			System.out.println(Direction.SOUTH_WEST.name());
		break;
		case '4':
			System.out.println(Direction.NORTH_WEST.name());
		break;
		}

	}


	@Override public void mousePressed(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void keyTyped(KeyEvent e) {}
	@Override public void keyReleased(KeyEvent e) {	}



}
