package Pioneers.Player;

import java.awt.Color;

import hexalib.HexaGrid;
import Pioneers.Hexagon.DataHexagon;

/**
 * @author adrien
 * this class generate a road on a new Hexagon.
 */
public class Road extends Player{
	private final DataHexagon modifiedHexa;
	private HexaGrid<DataHexagon> hexagrid;
	private int q;
	private int r;
	
	public Road(String name, Color color, HexaGrid<DataHexagon> hexagrid,int q, int r) {
		super(name, color);
		this.modifiedHexa = new DataHexagon();
		this.hexagrid = hexagrid;
		this.q = q;
		this.r = r;
	}


	public void putRoad(){
		modifiedHexa.setColor(hexagrid.getData(q,r).getColor());
		modifiedHexa.setEdgeColor(hexagrid.getData(q, r).getAllEdgeColor());
		modifiedHexa.setDirection(super.getActiveDirection());
		modifiedHexa.setOneEdgeColor(super.getColor());
		hexagrid.setData(q,r, modifiedHexa);
	}
	
	
}
