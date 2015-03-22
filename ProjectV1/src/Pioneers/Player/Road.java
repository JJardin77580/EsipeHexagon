package Pioneers.Player;

import java.awt.Color;

import hexalib.HexaGrid;
import hexalib.Hexalib.Direction;
import Pioneers.Hexagon.DataHexagon;

public class Road{
	private DataHexagon modifiedHexa;
	private final int q;
	private final int r;
	private final HexaGrid<DataHexagon> hexagrid;
	private final Color color;
	
	public Road(HexaGrid<DataHexagon> hexagrid,int q,int r,Color color,Direction roadDir) {
		this.hexagrid = hexagrid;
		this.q = q;
		this.r = r;
		this.color = color;
		modifiedHexa = new DataHexagon();
		modifiedHexa.setColor(hexagrid.getData(q,r).getColor());
		modifiedHexa.setEdgeColor(hexagrid.getData(q, r).getEdgeColor());
		modifiedHexa.setDirection(roadDir);
		modifiedHexa.setOneEdgeColor(color);
		hexagrid.setData(q,r, modifiedHexa);
	}
	
	
	
	
	
	
	

}
