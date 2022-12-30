package Boulangerie;

public class Produit {
	private String nom;
	private int nombre;
	private int prix;
	
	public Produit(String nom, int nombre, int prix) {
		this.nom = nom;
		this.nombre= nombre;
		this.prix = prix;	
	}
	
	public String getNom() {
		return nom;
	}

	public int getNombre() {
		return nombre;
	}

	public int getPrix() {
		return prix;
	}

	public void reduireQuantitee(int nbSouhaite) {
		nombre= nombre-nbSouhaite;
	}
	public void augmenterQuantitee(int nbSouhaite) {
		nombre=nombre+nbSouhaite;
	}


	
	
}
