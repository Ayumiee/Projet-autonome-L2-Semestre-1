package Boulangerie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Personnages.Boulanger;

public class Machine {
	private static Inventaire inventaire;
	private int benefice=0; 
	private Boulanger boulanger;
	
	public Machine() {
		inventaire = new Inventaire();
		boulanger = new Boulanger("Le boulanger",100,null);
	}
	
	public void acheter(int produit,int argent, int nbSouhaite, Machine distributeur) throws InterruptedException {
		
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
		System.out.println("Cuisson en cours...");
		produitDemande.reduireQuantitee(nbSouhaite);
		augmenterBenefice(prix);
		int monnaieARendre = rendreMonnaie(argent, prix);
		return monnaieARendre;
		}

	private void AnnulerTransaction(int argent, String nomErreur, Machine distributeur) throws InterruptedException {
		System.out.println(nomErreur+"\nTransaction annulée");
		rendreMonnaie(argent, 0);
		Main.menuClient(distributeur);
	}
	
	private int rendreMonnaie(int argent, int prix) {
		int monnaieRendu = argent - prix;
		System.out.println("Monnaie rendue :"+ monnaieRendu);
		return monnaieRendu;
	}
	
	protected int recupererArgent() {
		int sauvBenefice= benefice;
		boulanger.gagnerArgent(benefice);
		benefice=0;
		return sauvBenefice;
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
	
	public void retirerProduit(Machine distributeur,int numProduit) throws InterruptedException {
		int nbProduit=getInventaire().getNbProduitTotaux();
		
		if ((numProduit>=0)&&(numProduit<nbProduit)) {
			inventaire.retirerInventaire(numProduit, null);
		}else {
			System.out.println("Numéro invalide");
			Main.menuBoulanger(distributeur);
		}
	}
	public void ajouterProduit(Machine distributeur,String nomProduit, int quantitee, int prix) {
		int nbProduit=getInventaire().getNbProduitTotaux();
		int MAXIMUM = getInventaire().getMAXIMUM();
		if (nbProduit<MAXIMUM) {
			inventaire.ajouterInventaire(nomProduit,quantitee,prix);
			inventaire.augmenterNbProduit();
		}else {
			System.out.println("La machine ne peut plus ajouter de nouveaux produit");
		}
	}

	private boolean verifierArgentSuffisant(int argent, int prix) {
		return (argent>=prix);
	}

	protected void augmenterQuantitee(Machine distributeur, int numProduit, int quantitee) {
		Produit produit=inventaire.numeroChoisisVersProduit(numProduit);
		produit.augmenterQuantitee(quantitee);
		System.out.println("Les produits ont été ajouté !");
	}
	public static Inventaire getInventaire() {
		return inventaire;
	}
	public Boulanger getBoulanger() {
		return boulanger;
	}

	public int getBenefice() {
		return benefice;
	}
	
}



