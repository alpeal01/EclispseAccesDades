package es.florida.T1FitArch;

import java.io.File;

public class Sec1_1 {

	//Realitza un programa que reba com a paràmetre d’entrada un directori i el mostre per pantalla.
	public static void main(String[] args) {
		
		File f = new File(args[0]);
		
		String [] lista  =f.list();
		
		
		for (String data : lista) {
			
			System.out.println(data);
			
		}
		
		
		
		
		
		
	}
	
}
