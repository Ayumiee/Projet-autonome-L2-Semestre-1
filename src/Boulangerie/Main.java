package Boulangerie;

//import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//methode cours int num_produit = Integer.parseInt(inputOutput("Que-souhaitez-vous achetez : \n -> 1 - Baguette \n -> 2 - Pain au chocolat \n -> 3 - Croissant \n"));
//Scanner utilisateur = new Scanner(System.in);
//System.out.println("Que-souhaitez-vous achetez : \n -> 1 - Baguette \n -> 2 - Pain au chocolat \n -> 3 - Croissant \n");
//int num_produit = utilisateur.nextInt();

public class Main {
	private Machine distributeur;
	
	public Main() {
		distributeur = new Machine();
	}
	
	public static void Start(Machine distributeur) {
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
	
	public static void menuClient(Machine distributeur) {
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
        
        
	private int demanderProduitDesiree() {
        	return Integer.parseInt(inputOutput("Que-souhaitez-vous achetez : \n -> 0 - Baguette \n -> 1 - Pain au chocolat \n -> 2 - Croissant \n"));
        }
        
	
	public static void menuBoulanger(Machine distributeur) {
		int action = Integer.parseInt(inputOutput("Que souhaitez-vous faire ?\n0 - Retirer un produit\n1 - Ajouter produit \n2 - Récupérer argent\n404- Retour menu "));
		switch(action) {
		case 0:
			System.out.println("Quel produit souhaitez-vous retirer ? Produits disponibles : \n");
			distributeur.afficherProduit();
			int numProduit=Integer.parseInt(inputOutput("Veuillez écrire le numéro correspondant"));
			distributeur.retirerProduit(distributeur,numProduit);
			Start(distributeur);
			break;
			
		case 1:
			break;
			
		case 2:
			break;
			
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

        	
        	
        	
        	
        	
    