package GelWar;

import hexalib.HexaGrid;
import hexalib.Hexalib.HexaGridView;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GoleConquest.Hexagon.DataHexagon;

public class Fenetre extends JFrame {

	public static int offsetX=500;
	public  static int offsetY=400;
	public Fenetre(HexaGridView<DataHexagon> hexaview,HexaGrid<DataHexagon> hexagrid) {             
	
		Plateau panel = new Plateau(hexaview,hexagrid);	 
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
