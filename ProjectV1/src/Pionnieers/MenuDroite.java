package Pionnieers;

import java.awt.Graphics;
import java.util.ArrayList;

import Pionnieers.ToolBox.Label;

/**
 * Menu de droite qui rassemble toutes les infos & la gestion du jeu
 * @author adrien
 *
 */

public class MenuDroite {
	private final ArrayList<Label> labelList;
	private final int startX = 500;
	
	public MenuDroite() {
		labelList = new ArrayList<Label>();
	}
	
	public void ecrireTexte(String txt,int posX,int posY){
		labelList.add(new Label(txt,posX,posY));
	}
	
	public void HUD(){
		ecrireTexte("MENU",startX +50,10);
	}
	
	
	public void afficherMenu(Graphics g){
		for(int i = 0 ; i < labelList.size() ; i++)
			labelList.get(i).drawText(g);
		labelList.clear();
	}
	
	
	
	
	
}
