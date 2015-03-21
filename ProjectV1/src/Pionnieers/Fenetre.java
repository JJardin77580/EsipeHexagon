package Pionnieers;

import hexalib.HexaGrid;
import hexalib.Hexalib.HexaGridView;

import java.awt.Container;

import javax.swing.JFrame;

import Pionnieers.Hexagon.DataHexagon;
/**
 * Initialise un fenetre
 * @author adrien
 *
 */
public class Fenetre extends JFrame {
	private static final long serialVersionUID = 1L;
	public static int offsetX=300;
	public  static int offsetY=300;
	
	
	public Fenetre(HexaGridView<DataHexagon> hexaview,HexaGrid<DataHexagon> hexagrid) {  
		Plateau panel = new Plateau(hexaview,hexagrid);
		JFrame frame = new JFrame("Pionnieers");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container content = frame.getContentPane();
		content.add(panel);
		frame.setSize(700,700);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true); 
		frame.addMouseListener(panel);
		
	}       
	
	
}