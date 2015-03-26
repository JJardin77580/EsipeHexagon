package GelWar;
import hexalib.HexaGrid;
import hexalib.Hexalib.HexaGridView;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Plateau extends JPanel implements MouseListener{
	private final HexaGridView<DataHexagon> hexagridView;
	private final HexaGrid<DataHexagon> hexagrid;
	private final ControllerGamePlayClickRight gameplay;

	public Plateau( HexaGridView<DataHexagon> hexaGridView,HexaGrid<DataHexagon> hexaGrid, Player[] players)
	{
		this.hexagridView=hexaGridView;
		this.hexagrid=hexaGrid;
		setBackground(Color.LIGHT_GRAY);
		gameplay=new ControllerGamePlayClickRight(hexagrid,players);

	} 

	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g; 
		super.paintComponent(g2);
		hexagridView.DrawGrid(g2);
		g2.setColor(gameplay.getPlayer().getColor());
		g2.drawString("Tour de " +gameplay.getPlayer().getName(), 425, 100);
	}





	@Override
	public void mouseClicked(MouseEvent e) {
		gameplay.dataInteracted(e);
		repaint();

	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


}
