package Pioneers.Player;

import java.awt.Color;

import hexalib.HexaGrid;
import hexalib.Hexalib.Direction;
import Pioneers.Hexagon.DataHexagon;

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
