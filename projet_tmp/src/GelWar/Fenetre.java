package GelWar;

import hexalib.Hexalib.HexaGridView;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	public static int offsetX=500;
	public  static int offsetY=500;
	public Fenetre(HexaGridView<Integer> hexaview) {             
		Plateau panel = new Plateau(hexaview);	 
		//JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("GelWAR");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Container content = frame.getContentPane();
		content.add(panel);
		//this.add(panel); -- cannot be done in a static context
		//for hexes in the FLAT orientation, the height of a 10x10 grid is 1.1764 * the width. (from h / (s+t))
		frame.setSize( (int)(1000),1000);
		frame.setResizable(true);
		frame.setLocationRelativeTo( null );
		frame.setVisible(true); 
		frame.addMouseListener(panel);
	
	}       
	
	
}
