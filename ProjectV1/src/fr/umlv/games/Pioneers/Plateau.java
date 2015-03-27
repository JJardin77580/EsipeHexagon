package fr.umlv.games.Pioneers;


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
	private final Player[] players;
	private final Label aide;
	private final Label des;
	private int activePlayer;


	public Plateau(HexaGridView<DataHexagon> hexaGridView,HexaGrid<DataHexagon> hexaGrid,Player[] players){
		this.hexagridView=hexaGridView;
		this.hexagrid=hexaGrid;
		this.players = players;
		this.activePlayer = -1;
		setBackground(Color.WHITE);
		aide = new Label("tirez les dés pour commencer une partie (clic droit)", 10, 20);
		des = new Label("", 10, 50);
	}

	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g; 
		super.paintComponent(g2);
		hexagridView.DrawGrid(g2);
		aide.drawText(g);
		des.drawText(g);
	}

	public int tirageDe(){
		Random rand = new Random();
		return rand.nextInt(6)+1;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)){
			LeftClickedMouse(e);
		}
		if(SwingUtilities.isRightMouseButton(e)){
			RightClickedMouse(e);
		}
		repaint();
	}

	private void LeftClickedMouse(MouseEvent e) {
		Coordinates c=Hexalib.PixelToCube(e.getX()-Fenetre.offsetX,e.getY()-30-Fenetre.offsetY,30);

		if(activePlayer != -1){
			players[activePlayer].addRoad(hexagrid,c.q,c.r);
			players[activePlayer].setActive(false);
			activePlayer++;
			if(activePlayer >= players.length){
				aide.setText("Veuillez lancer les dés pour un nouveau tour");
			}
			else {
				aide.setText("c'est a " + players[activePlayer].getName() + " de jouer");
				players[activePlayer].setActive(true);
			}
		}
	}
	private void RightClickedMouse(MouseEvent e) {
		if(activePlayer >= players.length || activePlayer == -1){
			activePlayer = 0;
			int num1 = tirageDe();
			int num2 = tirageDe();
			int total = num1 + num2;
			System.out.println("tirage des dés : " + num1 + "," + num2 + " -> " + total);
			des.setText("tirage des dés : " + num1 + "," + num2 + " -> " + total);
			aide.setText("c'est a " + players[activePlayer].getName() + " de jouer");
		}
		else
			System.out.println("ce n'est pas le moment de lancer les dés ! (" + players[activePlayer].getName() + " joue!)");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyChar()){
			case '1': players[activePlayer].setActiveDirection(Direction.SOUTH_WEST);	break;
			case '2': players[activePlayer].setActiveDirection(Direction.SOUTH); 		break;
			case '3': players[activePlayer].setActiveDirection(Direction.SOUTH_EAST);	break;
			case '4': players[activePlayer].setActiveDirection(Direction.NORTH_WEST);	break;
			case '5': players[activePlayer].setActiveDirection(Direction.NORTH); 		break;
			case '6': players[activePlayer].setActiveDirection(Direction.NORTH_EAST); 	break;
		}
	}


	@Override public void mousePressed(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void keyTyped(KeyEvent e) {}
	@Override public void keyReleased(KeyEvent e) {	}



}
