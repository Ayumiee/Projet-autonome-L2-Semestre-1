package Boulangerie;


public class Machine {
	private static Inventaire inventaire;
	
	public Machine() {
		inventaire = new Inventaire();
	}
	
	public void achat(int produit,int argent) {
		int prix = inventaire.tabProduit[produit].getPrix();
		if (argent>=prix) {
			
		}else {
			
		}
	}
	
	
	public static void main(String[] args) {
		Machine machine = new Machine();
	}
}



