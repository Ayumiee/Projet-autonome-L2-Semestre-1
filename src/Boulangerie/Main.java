package Boulangerie;

//import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import Personnages.Boulanger;

public class Main {
	private Machine distributeur;

	
	public Main() {
		distributeur = new Machine();
	}
	
	public static void Start(Machine distributeur) throws InterruptedException {
		try {
		int choixMenu = Integer.parseInt(inputOutput("0 - Achat \n1 - Maintenance"));
		
		switch (choixMenu) {
		case 0:
			menuClient(distributeur);
		case 1:
			menuBoulanger(distributeur);
		default:
			System.out.println("Numéro invalide");
			Start(distributeur); 
			}
		
		} catch(NumberFormatException entier) {
			System.out.println("Veuillez rentrer un chiffre");
			Start(distributeur);
			}
		
	}
	
	public static void menuClient(Machine distributeur) throws InterruptedException {
        try {
        	System.out.println("Que souhaitez-vous achetez ?");
        	distributeur.afficherProduit();
        	System.out.println("404 - Retour menu");
        	int num_produit = Integer.parseInt(inputOutput("Veuillez écrire le numéro correspondant"));
        	if (num_produit==404) {
        		Start(distributeur);
        	}
        	if (num_produit>=0 && num_produit<distributeur.getInventaire().getNbProduit()) {
        		Machine.getInventaire();
				int nb_restant = Inventaire.getTabProduit()[num_produit].getNombre();
        		
        		if (nb_restant >0) {
        		int nb_souhaite = Integer.parseInt(inputOutput("Combien en souhaitez-vous ? Il en reste : "+ nb_restant ));
      
        			if (nb_souhaite>0 && nb_souhaite<=nb_restant) {
        			
        				int argent = Integer.parseInt(inputOutput("Veuillez insérer la monnaie"));
        					distributeur.acheter(num_produit,argent,nb_souhaite,distributeur);
        					Start(distributeur);
        			}else {
        				System.out.println("Nombre souhaité indisponible");
        				menuClient(distributeur);
        			}
        		} 
        		else {
        			System.out.println("Il n'y en a plus ");
    				menuClient(distributeur);
        		}
        	} 
        	else {
				System.out.println("Numéro invalide");
				menuClient(distributeur);
				}	
			} 
        catch (NumberFormatException e ) {
			System.out.println("Veuillez rentrer un chiffre");
			menuClient(distributeur);
		}
	}
        
	
	public static void menuBoulanger(Machine distributeur) throws InterruptedException {
		int action = Integer.parseInt(inputOutput("Que souhaitez-vous faire ?\n0 - Retirer un produit\n2 - Récupérer argent\n3 - Ajouter quantité\n404- Retour menu "));
		switch(action) {
		case 0:
			System.out.println("Quel produit souhaitez-vous retirer ? Produits disponibles : \n");
			distributeur.afficherProduit();
			int numProduitRetire=Integer.parseInt(inputOutput("Veuillez écrire le numéro correspondant"));
			distributeur.retirerProduit(distributeur,numProduitRetire);
			Start(distributeur);
			
//		case 1:
//			
//			//BUG
//			System.out.println("Quel produit souhaitez-vous ajouter ? Produits disponibles : \n");
//			distributeur.afficherProduit();
//			System.out.println("Veuillez entrez le nom du nouveau produit");
//			Scanner lecteur = new Scanner(System.in);
//			String nom = lecteur.next();
//			System.out.println("Quelle est la quantitée disponible actuellement?");
//			int nombre = lecteur.nextInt();
//			System.out.println("Combien coûte ce nouveau produit?");
//			int prix = lecteur.nextInt();
//			distributeur.ajouterProduit(distributeur,nom,nombre,prix);
//			Start(distributeur);
			
		case 2:
			System.out.println("Ouverture de la trappe....");
			Thread.sleep(1000);
			int benefice = distributeur.recupererArgent();
			Start(distributeur);
		
		case 3:
			System.out.println("Votre demande concerne quel produit ? Produits disponibles : \n");
			distributeur.afficherProduit();
			int numProduitAjout=Integer.parseInt(inputOutput("Veuillez écrire le numéro correspondant"));
			int quantitee=Integer.parseInt(inputOutput("Quelle quantitée souhaitez vous ajouter ?"));
			distributeur.augmenterQuantitee(distributeur,numProduitAjout,quantitee);
			Start(distributeur);
			
		case 404: 
			Start(distributeur);
			
		default:
			System.out.println("Numéro invalide");
			menuBoulanger(distributeur);
			break;
		}
	}
        	
    private static String inputOutput(String message) {
        System.out.println(message);
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String returnString = "";
	    try {
	        returnString = br.readLine();
	    }
	    catch (IOException e){
	        System.out.println("Error reading in value");
	       
	    }
	    return returnString;
    }
	

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Démarrage de la nouvelle machine ...");
		Thread.sleep(1000);
		System.out.println("Chargement...");
		Thread.sleep(1000);
		System.out.println("......");
		Thread.sleep(1000);
		System.out.println("Bienvenue !");

		Machine distributeur = new Machine();
		Start(distributeur);
	}

}

        	
        	
        	
        	
        	
    