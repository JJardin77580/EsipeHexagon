package fr.umlv.games.Pioneers;

import java.awt.Graphics;

/**
 * @author adrien
 * this class configures a label
 */
public class Label {
	private String text; 
	private final int posX;
	private final int posY;
	
	public Label(String text, int posX, int posY) {
		this.text = text;
		this.posX = posX;
		this.posY = posY;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public void drawText(Graphics g){
		g.drawString(text, posX, posY);
	}
	
	
}
