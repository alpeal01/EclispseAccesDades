package es.florida.T1FitArch;

public class Personaje {
	
	int id;
	String nombre;
	int vida;
	int armadura;
	
	
	public Personaje(int id, String n,int v,int arm) {
		
		this.id = id;
		this.nombre=n;
		this.vida = v;
		this.armadura = arm;
		
	}
	
	public int getId() {
		return this.id;
	}
	
	public String nombre() {
		return this.nombre;
	}
	
	public int vida() {
		return this.vida;
	}
	
	public int armadura () {
		return this.armadura;
	}

}
