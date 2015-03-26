package Pioneers;

import java.util.ArrayList;
import java.util.Random;

import Pioneers.Hexagon.DataHexagon.TypeHex;

/**
 * This class generate cases with available ressources. (gived by the TypeHex enum)
 * @author adrien
 **/
public class GenerateTerrain {
	private final ArrayList<CoupleVN> cases;

	public GenerateTerrain() {
		cases = new ArrayList<CoupleVN>();
	}
	
	public void initialize(int nbDiffTerrain){
		for(int valeur = 0 ; valeur < nbDiffTerrain ; valeur++){
			int nombre = TypeHex.values()[valeur].getCapacity();
			cases.add(new CoupleVN(nombre,valeur));
		}
	}

	public int getCase() {
		if(cases.size() < 1)
			throw new IndexOutOfBoundsException("Erreur : le nombre de valeurs n'est pas suffisant (HexType.capacity)");
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




