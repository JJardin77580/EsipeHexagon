package fr.umlv.games.Pioneers;

import hexalib.HexaGrid;
import hexalib.Hexalib.Direction;

import java.awt.Color;
import java.util.ArrayList;
/**
 * @author adrien
 * this class allow configurations of a player
 **/
public class Player {
	private final String name;
	private final Color color;
	private ArrayList<Road> road;
	private ArrayList<Town> town;
	private ArrayList<Colony> colony;
	private ArrayList<Integer> listRessources;
	private Direction activeDirection;
	private boolean active;

	public enum Resources{
		WOOD(0),WHEAT(0),CLAY(0),SHEEP(0),STONE(0);
		
		private int quantity;

		Resources(int quantity){this.quantity = quantity;}
		public int getQuantity(){return this.quantity;}
		public void setQuantity(int quantity){this.quantity = quantity;}
	};
	
	public Player(String name, Color color) {
		this.name=name;
		this.color=color;
		listRessources = new ArrayList<Integer>();
		road = new ArrayList<Road>();
		activeDirection = Direction.NORTH;
	}

	public void addRoad(HexaGrid<DataHexagon> hexagrid, int q, int r){
		road.add(new Road(name,color,hexagrid,q,r));
		road.get(road.size()-1).putRoad();
	}
	
	public void addTown(){
		town.add(new Town());
	}

	public void setActiveDirection(Direction activeDirection) {
		this.activeDirection = activeDirection;
	}
	public Direction getActiveDirection() {
		return this.activeDirection;
	}

	public void addColony(){
		colony.add(new Colony());
	}

	public void getRessources(Resources res){
		int index = res.ordinal();
		listRessources.set(index,listRessources.get(index)+1);
	}
	
	public int getNbPoints(){
		return colony.size()+(town.size()*2);
	}
	
	public void setActive(boolean active) {this.active = active;}
	public boolean isActive() {return this.active;}
	public String getName()	  {return this.name;}
	public Color getColor()	  {return this.color;}
	
}
