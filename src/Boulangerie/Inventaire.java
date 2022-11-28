package Boulangerie;

public class Inventaire {
	public static Produit[] tabProduit = new Produit[3];
	
	public Inventaire() {
		Produit baguette = new Produit("baguette",0,1);
		Produit painChocolat = new Produit("pain au chocolat",0,1);
		Produit croissant = new Produit("croissant",0,1);
		
		tabProduit[0]=baguette;
		tabProduit[1]=painChocolat;
		tabProduit[2]=croissant;
	}
	
	public static void main(String[] args) {
		Produit baguette = new Produit("baguette",0,1);
		Inventaire invent = new Inventaire();
		System.out.println(tabProduit[0].getNom());
		
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



