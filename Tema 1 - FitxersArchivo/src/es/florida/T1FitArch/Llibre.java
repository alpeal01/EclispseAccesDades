package es.florida.T1FitArch;

import java.util.Scanner;

public class Llibre {
	
	 int identificador;
	String títol;
	String autor;
	int any;
	String editorial;
	int numPag;
	public int getIdentificador() {
		return identificador;
	}
	public String getTítol() {
		return títol;
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
		super();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Indica Identificador: ");
		this.identificador = sc.nextInt();
		
		System.out.println("Indica Titulo");
		this.títol = sc.nextLine();
		
		System.out.println("Indica autor");
		this.autor = sc.nextLine();
		
		System.out.println("Indica any");
		this.any = sc.nextInt();
		
		System.out.println("Indica editorial");
		this.editorial = sc.nextLine();
		
		System.out.println("Indica Numero de paginas");
		this.numPag = sc.nextInt();
		
		sc.close();
		
	}
	
	

	
	
	
	

}
