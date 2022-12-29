package Personnages;

import Boulangerie.Machine;
import Boulangerie.Produit;

public class Boulanger extends Humain{
	private Machine distributeur;

	public Boulanger(String nom, int argent, Produit[] poche) {
		super(nom, argent, poche);
	
	}

}
