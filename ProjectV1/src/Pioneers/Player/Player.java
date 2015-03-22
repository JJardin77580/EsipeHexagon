package Pioneers.Player;

import hexalib.HexaGrid;
import hexalib.Hexalib.Direction;

import java.awt.Color;
import java.util.ArrayList;

import Pioneers.Hexagon.DataHexagon;

public class Player {
	private final String name;
	private final Color color;
	private ArrayList<Road> road;
	private ArrayList<Town> town;
	private ArrayList<Colony> colony;
	private ArrayList<Integer> listRessources;
	private boolean active;
	private Direction roadDir;
	public enum Ressources{BOIS(0),BLE(0),ARGILE(0),MOUTON(0),PIERRE(0);
		private int quantity;

	Ressources(int quantity){this.quantity = quantity;}
	public int getQuantity(){return this.quantity;}
	public void setQuantity(int quantity){this.quantity = quantity;}
	};
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Player(String name, Color color) {
		this.name=name;
		this.color=color;
		listRessources = new ArrayList<Integer>();
		active = false;
		road = new ArrayList<Road>();
		roadDir = Direction.NORTH;
	}
	
	public void addTown(){
		town.add(new Town());
	}
	
	public void addRoad(HexaGrid<DataHexagon> hexagrid, int q, int r){
		road.add(new Road(hexagrid,q,r,color,roadDir));
	}

	public void setRoadDir(Direction roadDir) {
		this.roadDir = roadDir;
	}

	public void addColony(){
		colony.add(new Colony());
	}

	public void getRessources(Ressources res){
		int index = res.ordinal();
		listRessources.set(index,listRessources.get(index)+1);
	}
	
	public String getName(){
		return this.name;
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public int getNbPoints(){
		return colony.size()+(town.size()*2);
	}
}
