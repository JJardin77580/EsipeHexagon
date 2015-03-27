package fr.umlv.games.Pioneers;

import java.util.ArrayList;
import java.util.Random;

/**
 * this class create tokens and give a token for each case (except sand and sea case)
 * @author adrien
 **/

public class Tokens {
	private static ArrayList<CoupleVN> token;
	
	
	public Tokens() {
		token = new ArrayList<CoupleVN>();
	}
	
	public void init() {
		int quantity=1;
		for(int nombre = 2 ; nombre <= 12 ; nombre++){
			if(nombre == 2 || nombre == 12)
				quantity = 1;
			else
				quantity = 2;
			if(nombre != 7)
				token.add(new CoupleVN(quantity,nombre));
		}
	}
	
	public int getJeton() {
		if(token.size() < 1)
			throw new IndexOutOfBoundsException("Erreur : plus de jetons disponible");
		Random rand = new Random();
		int index = rand.nextInt(token.size());
		int value = token.get(index).getValeur();
		if(token.get(index).getNombre() > 1)
			token.get(index).removeOne();
		else {
			token.get(index).removeOne();
			token.remove(index);
		}
		return value;
	}
}
