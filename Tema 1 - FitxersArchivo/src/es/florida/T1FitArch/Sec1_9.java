package es.florida.T1FitArch;


import java.io.File;
import java.util.Scanner;

public class Sec1_9 {
	static void getInformacio() {
		
	}
	static void creaCarpeta() {
		
	}
	
	static void creaFitxer() {
		
	}
	
	static void elimina() {
		
	}
	
	static void renomena() {
		
	}
	
	static File ruta() {
		Scanner sc = new Scanner(System.in);
		File f;
		String ruta;
		System.out.print("Indica ruta relativa: ");
		ruta = sc.nextLine();
		f = new File(ruta);
		sc.close();
		return f;
	}
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean loop = true;
		int op;
		
		do {
			

			
			
			
			System.out.println("------Menu-----");
			System.out.println("1) Informacion");
			System.out.println("2) Crear Carpeta");
			System.out.println("3) Crear Fichero");
			System.out.println("4) Eliminar Fichero");
			System.out.println("5) Renombrar Fichero");
			System.out.println("6) Cerrar");
			
			op = sc.nextInt();
			
			switch (op) {
			case 1: {
				
				getInformacio();
				break;
				
			}
			case 2:{
				
				creaCarpeta();
				break;
				
			}
			case 3:{
				creaFitxer();
				break;
			}
			case 4:{
				elimina();
				break;
			}
			case 5:{
				renomena();
				break;
			}
			case 6:{
				loop = false;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + op);
			}
			
		}while(loop);
		sc.close();
	}

}
