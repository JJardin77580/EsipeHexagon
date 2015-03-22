package Pioneers;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;

import Pioneers.Player.Player;
import Pioneers.ToolBox.Label;

/**
 * Menu de droite qui rassemble toutes les infos & la gestion du jeu
 * @author adrien
 *
 */

public class MenuDroite extends JLabel{
	private final ArrayList<Label> labelList;
	private final int startX = 500;
	
	public MenuDroite() {
		labelList = new ArrayList<Label>();
	}
	
	public void ecrireTexte(String txt,int posX,int posY){
		labelList.add(new Label(txt,posX,posY));
	}
	
	public void HUD(Player[] players){
		//ecrireTexte("Au joueur " + players + "de jouer",startX +50,20);
	}
	
	
	public void afficherMenu(Graphics g){
		for(int i = 0 ; i < labelList.size() ; i++)
			labelList.get(i).drawText(g);
		labelList.clear();
	}
	
	
	
	
	
}
