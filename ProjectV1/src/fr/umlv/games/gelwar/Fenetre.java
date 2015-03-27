package fr.umlv.games.gelwar;

import hexalib.HexaGrid;
import hexalib.Hexalib.HexaGridView;
import java.awt.Container;
import javax.swing.JFrame;



public class Fenetre extends JFrame {

	/**
	 * Fenètre du jeu GelWar
	 */
	private static final long serialVersionUID = 1L;
	/** Offset en X pour center **/
	public static int offsetX=500;
	/** Offset en Y pour centrer **/
	public  static int offsetY=400;
	public Fenetre(HexaGridView<DataHexagon> hexaview,HexaGrid<DataHexagon> hexagrid,Player[] player) {             
		
		
		
		
		Plateau panel = new Plateau(hexaview,hexagrid,player);	 
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("GelWAR");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Container content = frame.getContentPane();
		content.add(panel);
		frame.setSize( (int)(1000),1000);
		frame.setResizable(true);
		frame.setLocationRelativeTo( null );
		frame.setVisible(true); 
		frame.addMouseListener(panel);
	
	}       
	
	
}
