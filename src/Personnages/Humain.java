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
	
	public int gagnerArgent(int gain){
		argent = argent + gain;
		return gain;
	}
	
	public int perdreArgent(int perte) {
		argent = argent - perte;
		return perte;
	}
	

}
