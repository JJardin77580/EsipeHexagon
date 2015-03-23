package Pioneers;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author adrien
 *
 */

public class Jetons {
	private static ArrayList<CoupleVN> jeton;
	
	
	public Jetons() {
		jeton = new ArrayList<CoupleVN>();
	}
	
	public void init() {
		int quantite=1;
		for(int nombre = 2 ; nombre <= 12 ; nombre++){
			if(nombre == 2 || nombre == 12)
				quantite = 1;
			else
				quantite = 2;
			if(nombre != 7)
				jeton.add(new CoupleVN(quantite,nombre));
		}
	}
	
	public int getJeton() {
		if(jeton.size() < 1)
			throw new IndexOutOfBoundsException("Erreur : plus de jetons disponible");
		Random rand = new Random();
		int index = rand.nextInt(jeton.size());
		int value = jeton.get(index).getValeur();
		if(jeton.get(index).getNombre() > 1)
			jeton.get(index).removeOne();
		else {
			jeton.get(index).removeOne();
			jeton.remove(index);
		}
		return value;
	}
}
