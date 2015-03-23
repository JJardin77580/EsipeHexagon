package Pioneers.Player;

import java.awt.Color;

import hexalib.HexaGrid;
import hexalib.Hexalib.Direction;
import Pioneers.Hexagon.DataHexagon;

public class Road{
	private DataHexagon modifiedHexa;
	
	public Road(HexaGrid<DataHexagon> hexagrid,int q,int r,Color color,Direction roadDir) {
		modifiedHexa = new DataHexagon();
		modifiedHexa.setColor(hexagrid.getData(q,r).getColor());
		modifiedHexa.setEdgeColor(hexagrid.getData(q, r).getAllEdgeColor());
		modifiedHexa.setDirection(roadDir);
		modifiedHexa.setOneEdgeColor(color);
		hexagrid.setData(q,r, modifiedHexa);
	}
	
	
}
