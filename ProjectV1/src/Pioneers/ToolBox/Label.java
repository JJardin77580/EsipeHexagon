package Pioneers.ToolBox;

import java.awt.Graphics;


public class Label {
	private final String text; 
	private final int posX;
	private final int posY;
	
	public Label(String text, int posX, int posY) {
		this.text = text;
		this.posX = posX;
		this.posY = posY;
	}
	
	public void drawText(Graphics g){
		g.drawString(text, posX, posY);
	}
	
	
}
