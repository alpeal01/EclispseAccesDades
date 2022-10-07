package es.florida.AE01;

import java.io.File;
import java.text.SimpleDateFormat;

public class Modelo {
	
	
	public String listFich (String dir) {
		
		File dFile= new File (dir);
		String [] list;
		String arch = "";
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

		
		if(dFile.exists()) {
		if(dFile.isFile()) {
				
			String[] fName = dFile.getName().split("\\.");

			
<<<<<<< Updated upstream
			 return "ARCHIVO"+"\nNombre: "+ fName[0]+
					 "\nExtensión: " +fName[1] +
					 "\nTamaño: "+dFile.getTotalSpace()+
=======
			 return "ARCHIVO"+"\nNombre: "+ dFile.getName()+
					 "\nExtensión: " +dFile.getName() +
					 "\nTamaño: "+dFile.getTotalSpace() +
>>>>>>> Stashed changes
					 "\nFecha creación: "+ df.format(dFile.lastModified())+
					 "\nUbicación: "+dFile.getAbsolutePath();
		
		}
		else {
			
			list = dFile.list();
			
			
			for (String file : list) {
				
				arch+= file + "\n";
			}
			
			return arch;
			
		}
		
		}else {
			return "Ruta no existe";
		}
	}

}
