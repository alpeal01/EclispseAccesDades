package es.florida.T1FitArch;
import java.io.File;
public class Sec1_4 {

	
	//Realitzar un programa que donat un directori, comprove si existeix i torne un missatge de
	// confirmació si existeix o una alerta en cas contrari.
	public static void main(String[] args) {
		
		File file = new File(args[0]);
		
		if(file.exists()) {
			
			System.out.println("Existe el directorio");
			
		}else
		{
			
			System.out.println("El directorio no existe");
			
		}
		
		
		
	}
	
	
}
