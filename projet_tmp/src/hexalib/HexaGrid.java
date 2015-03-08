package hexalib;
import hexalib.Hexalib.HexaModel;
import hexalib.Hexalib.ModelObserver;

import java.util.ArrayList;
import java.util.HashMap;

public class HexaGrid<T> implements HexaModel<T> {

	private final int minQ;
	private final int maxQ;
	private final int minR;
	private final int maxR;
	private final HashMap<Coordinates,T> grid;
	private final ArrayList<ModelObserver> observers;

	public HexaGrid(int minQ,int minR,int maxQ,int maxR) {
		this.minQ=minQ;
		this.maxQ=maxQ;
		this.minR=minR;
		this.maxR=maxR;
		grid=new HashMap<>();
		observers=new ArrayList<>();
	}
	@Override
	public int getMinQ() {
		return minQ;
	}

	@Override
	public int getMaxQ() {
	
		return maxQ;
	}

	@Override
	public int getMinR() {
	
		return minR;
	}

	@Override
	public int getMaxR() {
	
		return maxR;
	}

	@Override
	public T getData(int q, int r) {
		
		return grid.get(new Coordinates(q, r));
	}

	@Override
	public void addObserver(ModelObserver observer) {
	 observers.add(observer);

	}

}
