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

		if (verifierArgentSuffisant(argent, prix)) {
			lancerTransaction(produitDemande, argent, nbSouhaite, prix); //monnaie a utiliser par la suite

		}else {
			AnnulerTransaction(argent, "Argent insuffisant" , distributeur);
			}
		}
		
	private int lancerTransaction(Produit produitDemande, int argent, int nbSouhaite,int prix) {
		System.out.println("Transaction acceptée !");
		produitDemande.reduireQuantitee(nbSouhaite);
		augmenterBenefice(prix);
		int monnaieARendre = rendreMonnaie(argent, prix);
		return monnaieARendre;
		}

	private void AnnulerTransaction(int argent, String nomErreur, Machine distributeur) {
		System.out.println(nomErreur+"\nTransaction annulée");
		rendreMonnaie(argent, 0);
		Main.menuClient(distributeur);
	}
	
	private int rendreMonnaie(int argent, int prix) {
		int monnaieRendu = argent - prix;
		System.out.println("Monnaie rendue :"+ monnaieRendu);
		return monnaieRendu;
	}
	
	private void augmenterBenefice(int prix) {
		benefice = benefice + prix;
	}

	public void afficherProduit() {
		int nbProduit= inventaire.nbProduit;
		int i=0;
		while (i<nbProduit) {
			Produit produit = inventaire.numeroChoisisVersProduit(i);
			System.out.println(i+" - "+produit.getNom()+" : "+produit.getNombre()+" disponibles");
			i=i+1;
		}
	}
	
	public void retirerProduit(Machine distributeur,int numProduit) {
		int nbProduit=distributeur.getInventaire().getNbProduitTotaux();
		
		if ((numProduit>=0)&&(numProduit<nbProduit)) {
			distributeur.inventaire.retirerInventaire(numProduit, null);
		}else {
			System.out.println("Numéro invalide");
			Main.menuBoulanger(distributeur);
		}
	}

	private boolean verifierArgentSuffisant(int argent, int prix) {
		return (argent>=prix);
	}

	public static Inventaire getInventaire() {
		return inventaire;
	}

	public int getBenefice() {
		return benefice;
	}
	
}



