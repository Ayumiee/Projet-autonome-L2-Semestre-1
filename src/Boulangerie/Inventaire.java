package Boulangerie;

public class Inventaire {
	protected int nbProduit;
	private static Produit[] tabProduit;
	private int MAXIMUM;
	
	public Inventaire() {
		this.nbProduit = 3;
		this.MAXIMUM=10;
		initialisation();
		}

	private void initialisation() {
		Produit baguette = new Produit("baguette",3,1);
		Produit painChocolat = new Produit("pain au chocolat",3,1);
		Produit croissant = new Produit("croissant",3,1);
		tabProduit= new Produit[10];
		tabProduit[0]=baguette;
		tabProduit[1]=painChocolat;
		tabProduit[2]=croissant;
		this.nbProduit = 3;
	}
	
	public static void main(String[] args) {
		Inventaire inventaire = new Inventaire();
		System.out.println(tabProduit[2].getNom());
		
		Produit sucette = new Produit("sucette",0,1);
		tabProduit[3]= sucette;
		System.out.println(tabProduit[3].getNom());
		System.out.println(numeroChoisisVersProduit(0));
		System.out.println(getTabProduit());
		

	}

	public static Produit numeroChoisisVersProduit(int produit) {
		return getTabProduit()[produit];
	}

	public int getNbProduitTotaux() {
		return nbProduit;
	}
	public int getMAXIMUM() {
		return MAXIMUM;
	}

	public void retirerInventaire(int emplacement,Produit produit) {
		int i=emplacement;
	
		while (i<nbProduit-1) {
		tabProduit[i]=tabProduit[i+1];
		i++;
		}
		tabProduit[nbProduit]=null;
		nbProduit--;
	}
	
	public void ajouterInventaire(String nom, int quantitee,int prix) {
		tabProduit[nbProduit]=new Produit(nom,quantitee,prix);
		augmenterNbProduit();
	}

	public static Produit[] getTabProduit() {
		return tabProduit;
	}

	public void augmenterNbProduit() {
		nbProduit++;
	}
	public int getNbProduit() {
		return nbProduit;
	}
	
	
}



