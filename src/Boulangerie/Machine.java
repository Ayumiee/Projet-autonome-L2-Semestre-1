package Boulangerie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Machine {
	private static Inventaire inventaire;
	private int benefice=0; 
	
	public Machine() {
		inventaire = new Inventaire();
	}
	
	public void acheter(int produit,int argent, int nbSouhaite, Machine distributeur) {
		
		Produit produitDemande = Inventaire.numeroChoisisVersProduit(produit);
		int prix = produitDemande.getPrix() * nbSouhaite;
		
		if (produitSuffisant(produitDemande, nbSouhaite)) {
			if (verifierArgentSuffisant(argent, prix)) {
				lancerTransaction(produitDemande, argent, nbSouhaite, prix); //monnaie a utiliser par la suite
				System.out.println("Transaction acceptée !");
			}else {
				AnnulerTransaction(argent, "Argent insuffisant" , distributeur);
				}
		} else {
		AnnulerTransaction(argent, "Nombre souhaité indisponible" , distributeur);
		}
	}

		
	private int lancerTransaction(Produit produitDemande, int argent, int nbSouhaite,int prix) {
		produitDemande.reduireQuantitee(nbSouhaite);
		augmenterBenefice(prix);
		int monnaieARendre = rendreMonnaie(argent, prix);
		return monnaieARendre;
		}

	private void AnnulerTransaction(int argent, String nomErreur, Machine distributeur) {
		System.out.println(nomErreur);
		System.out.println("Transaction annulée");
		rendreMonnaie(argent, 0);
		Main.Menu_client(distributeur);
	}
	
	public boolean produitSuffisant(Produit produit, int nbSouhaite) {
		int nombreDispo = produit.getNombre();
		if ((nbSouhaite <= nombreDispo ) && (nbSouhaite >0)) {
			return true;
		}
		return false;
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
	
}



