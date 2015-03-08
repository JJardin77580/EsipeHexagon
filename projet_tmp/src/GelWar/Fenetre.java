package GelWar;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	public Fenetre(){             

		this.setTitle("Ma première fenêtre Java");
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);               
		//Instanciation d'un objet JPanel
		       
		this.setVisible(true);
	}       

}
