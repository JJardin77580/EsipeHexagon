package GelWar;

import java.awt.Color;
import java.util.HashMap;

import hexalib.Hexalib.Direction;
import hexalib.Hexalib.HexagonView;

public class HexagonPanel implements HexagonView {

	private  Color color;
	private int size;
	private HashMap<Direction, Color> colorEdge= new HashMap<>();

	@Override
	public void setColor(Color color) {
		this.color=color;
	}

	@Override
	public void setEdge(Direction edge, Color color) {
		colorEdge.put(edge, color);

	}

	@Override
	public void setSize(int size) {
		this.size=size;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}

	@Override
	public Color getEdgeColot(Direction edge) {
		// TODO Auto-generated method stub
		return this.colorEdge.get(edge);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.size;
	}



}
