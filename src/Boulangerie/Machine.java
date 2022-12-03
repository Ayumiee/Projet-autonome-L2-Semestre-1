package Boulangerie;

public class Machine {
	private static Inventaire inventaire;
	private int benefice; //b du boulanger
	
	public Machine() {
		inventaire = new Inventaire();
	}
	
	public void achat(int produit,int argent, int nbSouhaite) {
		
		Produit produitDemande = inventaire.getTabProduit()[produit];
		int prix = produitDemande.getPrix();
		
		if (argent>=prix) {
			produitDemande.reduireQuantitee(nbSouhaite);
			benefice = benefice + prix;
			int monnaieARendre = argent - prix;
		}else {
			
		}
	}
	


	public static Inventaire getInventaire() {
		return inventaire;
	}

	public int getBenefice() {
		return benefice;
	}
	
	public static void main(String[] args) {
		Machine machine = new Machine();
	}
}



