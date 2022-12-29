package Personnages;

import Boulangerie.Produit;

public class Client extends Humain{
	private String carteClient;
	
	public Client(String nom, int argent, Produit[] poche, String carteClient) {
		super(nom, argent, poche);
		this.carteClient=carteClient;
	}
	
}
