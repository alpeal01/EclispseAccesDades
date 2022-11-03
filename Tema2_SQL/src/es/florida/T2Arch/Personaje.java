package es.florida.T2Arch;

import java.util.Scanner;

public class Personaje {
	
	static int id = 0;
	String nombre;
	int vida;
	int ataque;
	int armadura;
	
	
	public Personaje( String n,int v,int arm, int atq) {
		
		Personaje.id++;
		this.nombre=n;
		this.vida = v;
		this.ataque = atq;
		this.armadura = arm;
		
	}
	
	public Personaje() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Indica nombre del personaje: ");
		this.nombre = sc.nextLine();
		
		System.out.println("Indica su vida: ");
		this.vida = sc.nextInt();
		
		System.out.println("Indica su ataque: ");
		this.ataque = sc.nextInt();
		
		System.out.println("Indica su armadura: ");
		this.armadura = sc.nextInt();
		
		
		
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getArmadura() {
		return armadura;
	}

	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}

	public int getId() {
		return Personaje.id;
	}
	
	public String nombre() {
		return this.nombre;
	}
	
	public int vida() {
		return this.vida;
	}
	
	public int ataque() {
		return this.ataque;
	}
	
	public int armadura () {
		return this.armadura;
	}

}
