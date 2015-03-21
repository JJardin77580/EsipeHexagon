package Pionnieers.Player;

import java.awt.Color;
import java.util.ArrayList;

public class Player {
	private final String name;
	private final Color color;
	private ArrayList<Road> road;
	private ArrayList<Town> town;
	private ArrayList<Colony> colony;
	private ArrayList<Integer> listRessources;
	public enum Ressources{BOIS,BLE,ARGILE,MOUTON,PIERRE};
	

	public Player(String name, Color color) {
		this.name=name;
		this.color=color;
		listRessources = new ArrayList<Integer>();
	}
	
	public void addTown(){
		town.add(new Town());
	}
	
	public void addRoad(){
		road.add(new Road());
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
