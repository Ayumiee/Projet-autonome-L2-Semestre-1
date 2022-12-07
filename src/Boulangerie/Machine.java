package Boulangerie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Machine {
	private static Inventaire inventaire;
	private int benefice=0; //b du boulanger
	
	public Machine() {
		inventaire = new Inventaire();
	}
	
	public void acheter(int produit,int argent, int nbSouhaite) {
		
		Produit produitDemande = Inventaire.numeroChoisisVersProduit(produit);
		int prix = produitDemande.getPrix() * nbSouhaite;
		
		if (verifierArgentSuffisant(argent, prix)) {
			lancerTransaction(produitDemande, argent, nbSouhaite, prix); //monnaie a utiliser par la suite
			
		}else {
			AnnulerTransaction(argent);
			
		}
	}
		
	private int lancerTransaction(Produit produitDemande, int argent, int nbSouhaite,int prix) {
		produitDemande.reduireQuantitee(nbSouhaite);
		augmenterBenefice(prix);
		int monnaieARendre = rendreMonnaie(argent, prix);
		return monnaieARendre;
		}

	private void AnnulerTransaction(int argent) {
		System.out.println("Argent insuffisant");
		rendreMonnaie(argent, 0);
		Main.Menu_client();
	}
	

	private int rendreMonnaie(int argent, int prix) {
		return argent - prix;
	}
	
	
	private void augmenterBenefice(int prix) {
		benefice = benefice + prix;
	}

	private boolean verifierArgentSuffisant(int argent, int prix) {
		if (argent>=prix) {
			return true;
		}
		return false;
	}

	public static Inventaire getInventaire() {
		return inventaire;
	}

	public int getBenefice() {
		return benefice;
	}
	
	
	public static void main(String[] args) {
		Machine machine = new Machine();
	}
}



