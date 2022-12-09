package es.florida.t4noSQL;

public class casa {
	
	int id;
	String nombre;
	int puertas;
	int ventanas;
	String problemas;
	public casa(int id, String nombre, int puertas, int ventanas, String problemas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.puertas = puertas;
		this.ventanas = ventanas;
		this.problemas = problemas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuertas() {
		return puertas;
	}
	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}
	public int getVentanas() {
		return ventanas;
	}
	public void setVentanas(int ventanas) {
		this.ventanas = ventanas;
	}
	public String getProblemas() {
		return problemas;
	}
	public void setProblemas(String problemas) {
		this.problemas = problemas;
	}
	
	

}
