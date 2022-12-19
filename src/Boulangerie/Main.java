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
	
	public static void Start() {
		Machine distributeur = new Machine();
		try {
		int choixMenu = Integer.parseInt(inputOutput("0 - Achat \n1 - Maintenance"));
		if (choixMenu==0) {
			Menu_client(distributeur); }
		
		else{
			if (choixMenu==1) {
				Menu_boulanger(); }
			else {
				System.out.println("Numéro invalide");
				Start(); }
			}
		
		} catch(NumberFormatException entier) {
			System.out.println("Veuillez rentrer un chiffre");
			Start();
			}
		
	}
	
	public static void Menu_client(Machine distributeur) {
        try {
        	int num_produit = Integer.parseInt(inputOutput("Que-souhaitez-vous achetez : \n -> 0 - Baguette \n -> 1 - Pain au chocolat \n -> 2 - Croissant \n"));

        	if (num_produit>=0 && num_produit<3) {
        		Machine.getInventaire();
				int nb_restant = Inventaire.getTabProduit()[num_produit].getNombre();
        		
        		if (nb_restant >0) {
        		int nb_souhaite = Integer.parseInt(inputOutput("Combien en souhaitez-vous ? Il en reste : "+ nb_restant ));
      
        			if (nb_souhaite>0 && nb_souhaite<=nb_restant) {
        			
        				int argent = Integer.parseInt(inputOutput("Veuillez insérer la monnaie"));
        					distributeur.acheter(num_produit,argent,nb_souhaite,distributeur);
        			}	
        		} 
        		else {
        			System.out.println("Il n'y en a plus ");
    				Menu_client(distributeur);
        		}
        	} 
        	else {
				System.out.println("Numéro invalide");
				Menu_client(distributeur);
				}	
			} 
        catch (NumberFormatException e ) {
			System.out.println("Veuillez rentrer un chiffre");
			Menu_client(distributeur);
		}
	}
        
        
	private int demanderProduitDesiree() {
        	return Integer.parseInt(inputOutput("Que-souhaitez-vous achetez : \n -> 0 - Baguette \n -> 1 - Pain au chocolat \n -> 2 - Croissant \n"));
        }
        
	
	public static void Menu_boulanger() {
		int action = Integer.parseInt(inputOutput("Que souhaitez-vous faire ?\n1 - Ajouter produit \n2 - Récupérer argent\n "));
		
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
	

	public static void main(String[] args) {
		System.out.println("Bienvenue !");
		//new boulanger 
		//Inventaire inventaire = distributeur.getInventaire();
		Start();
	}

}

        	
        	
        	
        	
        	
    