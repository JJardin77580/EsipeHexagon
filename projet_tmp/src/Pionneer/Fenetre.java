package Pionneer;

import hexalib.Hexalib.HexaGridView;
import java.awt.Container;
import javax.swing.JFrame;
/**
 * Initialise un fenetre
 * @author adrien
 *
 */
public class Fenetre extends JFrame {
	public static int offsetX=50;
	public  static int offsetY=50;
	private final int sizeHexagon = 30;
	
	
	public Fenetre(HexaGridView<Integer> hexaview) {  
		Plateau panel = new Plateau(hexaview,sizeHexagon);
		JFrame frame = new JFrame("Pionneer (les colons de catane)");
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
