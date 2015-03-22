package Pioneers;

import java.util.ArrayList;
import java.util.Random;

public class Jetons {
	private static ArrayList<CoupleVN> jetons;
	
	
	public Jetons() {
		jetons = new ArrayList<CoupleVN>();
	}
	
	public void initJetons() {
		int quantite=1;
		for(int nombre = 2 ; nombre <= 12 ; nombre++){
			if(nombre == 2 || nombre == 12)
				quantite = 1;
			else
				quantite = 2;
			if(nombre != 7)
				jetons.add(new CoupleVN(quantite,nombre));
		}
	}
	
	public int getJeton() {
		if(jetons.size() < 1)
			throw new IndexOutOfBoundsException();
		Random rand = new Random();
		int index = rand.nextInt(jetons.size());
		int value = jetons.get(index).getValeur();
		if(jetons.get(index).getNombre() > 1)
			jetons.get(index).removeOne();
		else {
			jetons.get(index).removeOne();
			jetons.remove(index);
		}
		return value;
	}
}
