package Personnages;

import Boulangerie.Machine;
import Boulangerie.Produit;

public class Boulanger extends Humain{
	private Machine distributeur;

	public Boulanger(String nom, int argent, Produit[] poche) {
		super(nom, argent, poche);
		this.argent = 100;
	
	}
	
	public int gagnerArgent(int benefice) {
		int argent=super.gagnerArgent(benefice);
		System.out.println("Vous avez récupéré "+ argent+ "euro");
		return argent;
	}

	
}
