package Boulangerie;

public class Inventaire {
	private int nbProduit;
	private static Produit[] tabProduit;
	
	public Inventaire() {
		this.nbProduit = 3;
		initialisation();
		}
		
	
	private void initialisation() {
		Produit baguette = new Produit("baguette",3,1);
		Produit painChocolat = new Produit("pain au chocolat",3,1);
		Produit croissant = new Produit("croissant",3,1);
		tabProduit= new Produit[]{baguette, painChocolat, croissant, null, null, null, null, null, null, null};
		this.nbProduit = 3;
	
	}
	
	public static void main(String[] args) {
		Inventaire inventaire = new Inventaire();
		System.out.println(tabProduit[2].getNom());
		
		Produit sucette = new Produit("sucette",0,1);
		tabProduit[3]= sucette;
		System.out.println(tabProduit[3].getNom());
		System.out.println(numeroChoisisVersProduit(0));
		

	}

	public static Produit numeroChoisisVersProduit(int produit) {
		return getTabProduit()[produit];
	}

	public int getNbProduit() {
		return nbProduit;
	}


	public static Produit[] getTabProduit() {
		return tabProduit;
	}
	
	


	
//	public int nbBaguette =1;
//	public int[] baguette = new int[4]; 
//	public int[] painChocolat =new int[4];;
//	private int[] croissant =new int[4];;
//	
//	
//	public Inventaire(int nbBaguette) {
//		this.nbBaguette = 2;
//		//quantitee
//		baguette[0]=1;
//		painChocolat[0]=1;
//		croissant[0]=1;
//		
//		// temps de cuisson
//		baguette[1]=10;
//		painChocolat[1]=5;
//		croissant[1]=4;	
//		
//		// température nécessaire
//		baguette[2]=200;
//		painChocolat[2]=180;
//		croissant[2]=170;
//		
//		//prix
//		baguette[3]=3;
//		painChocolat[3]=2;
//		croissant[3]=1;
//	}
//	
//	public int getbaguette(int[] baguette) {
//		return baguette[0];
//	}
//	}
	
	
	
}



