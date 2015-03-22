package Pioneers;

public class CoupleVN {
	
	private int nombre;
	private int valeur;


	public CoupleVN(int nombre, int valeur) {
		this.nombre = nombre;
		this.valeur = valeur;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
	public void removeOne(){
		nombre--;
	}	
}