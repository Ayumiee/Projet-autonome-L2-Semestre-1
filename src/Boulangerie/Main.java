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
	
	
	public static void Start() {
		try {
		int choixMenu = Integer.parseInt(inputOutput("0 - Achat \n1 - Maintenance"));
		if (choixMenu==0) {
			Menu_client(); }
		
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
	
	public static void Menu_client() {

        try {
        	int num_produit = Integer.parseInt(inputOutput("Que-souhaitez-vous achetez : \n -> 0 - Baguette \n -> 1 - Pain au chocolat \n -> 2 - Croissant \n"));
			
        	if (num_produit>=0 && num_produit<3) {
				int argent = Integer.parseInt(inputOutput("Veuillez insérer la monnaie"));
        		//achat(num_produit,argent);
        		System.out.println(num_produit+" "+argent);
        		} 
        	else {
				System.out.println("Numéro invalide");
				Menu_client();
				}	
			} 
        catch (NumberFormatException entier) {
			System.out.println("Veuillez rentrer un chiffre");
			Menu_client();
		}
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
		Machine distributeur = new Machine();
		Start();
	}

}

        	
        	
        	
        	
        	
    