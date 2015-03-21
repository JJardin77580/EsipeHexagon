package Pionnieers;

import java.util.ArrayList;
import java.util.Random;

import Pionnieers.Hexagon.DataHexagon.TypeHex;

/**
 * Génération du terrain en fonction des ressources disponnibles
 * @author root
 *
 */
public class GenerateTerrain {
	private final ArrayList<Jeton> cases;
	
	public GenerateTerrain() {
		cases = new ArrayList<Jeton>();
		for(int valeur = 0 ; valeur < TypeHex.values().length-2 ; valeur++){// (-2) supression de la mer et de la marina
			int nombre = TypeHex.values()[valeur].getCapacity();
			cases.add(new Jeton(nombre,valeur));
		}
	}
	
	public int getCase() {
		if(cases.size() < 1)
			throw new IndexOutOfBoundsException("caca");
		Random rand = new Random();
		int index = rand.nextInt(cases.size());
		int value = cases.get(index).getValeur();
		if(cases.get(index).getNombre() > 1)
			cases.get(index).removeOne();
		else {
			cases.get(index).removeOne();
			cases.remove(index);
		}
		return value;
	}
}




