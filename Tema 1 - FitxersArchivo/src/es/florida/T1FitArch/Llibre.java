package es.florida.T1FitArch;

import java.util.Scanner;

public class Llibre {
	
	 int identificador;
	String titol;
	String autor;
	int any;
	String editorial;
	int numPag;
	
	public int getIdentificador() {
		return identificador;
	}
	public String getTitol() {
		return titol;
	}

	public String getAutor() {
		return autor;
	}

	public int getAny() {
		return any;
	}

	public String getEditorial() {
		return editorial;
	}

	public int getNumPag() {
		return numPag;
	}
	public Llibre() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Indica Identificador: ");
		this.identificador =Integer.parseInt(sc.nextLine()) ;
		
		System.out.println("Indica Titulo");
		this.titol = sc.nextLine();
		
		System.out.println("Indica autor");
		this.autor = sc.nextLine();
		
		System.out.println("Indica any");
		this.any = Integer.parseInt(sc.nextLine()) ;
		
		System.out.println("Indica editorial");
		this.editorial = sc.nextLine();
		
		System.out.println("Indica Numero de paginas");
		this.numPag = Integer.parseInt(sc.nextLine()) ;
		
		sc.close();
		
	}
	public Llibre(String identificador, String titol, String autor, String any, String editorial, String numPag) {
		super();
		this.identificador = Integer.parseInt(identificador);
		this.titol = titol;
		this.autor = autor;
		this.any = Integer.parseInt(any);
		this.editorial = editorial;
		this.numPag = Integer.parseInt(numPag);
	}
	
	
	
	

	
	
	
	

}
