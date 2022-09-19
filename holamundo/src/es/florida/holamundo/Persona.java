package es.florida.holamundo;

public class Persona {

	String nom;
	String cognom;
	int edat;

	Persona(String nom, String cog, int ed) {

		this.nom = nom;
		this.cognom = cog;
		this.edat = ed;
	}

	public String getNom() {
		return nom;
	}

	public String getCognom() {
		return cognom;
	}

	public int getEdat() {
		return edat;
	}

	@Override
	public String toString() {
		return "Persona [nom=" + nom + ", cognom=" + cognom + ", edat=" + edat + "]";
	}
	
	

}
