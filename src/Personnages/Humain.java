package Personnages;

import Boulangerie.Produit;

public class Humain {
	protected String nom;
	protected int argent;
	protected Produit[] poche;
	
	
	public Humain(String nom,int argent, Produit[] poche) {
		this.nom=nom;
		this.argent=0;
		this.poche = new Produit[3];
	}
	
	protected int gagnerArgent(int gain){
		argent = argent + gain;
		return argent;
	}
	
	protected int perdreArgent(int perte) {
		argent = argent - perte;
		return argent;
	}
	

}
