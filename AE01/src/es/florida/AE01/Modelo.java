package es.florida.AE01;

import java.io.File;

public class Modelo {
	
	
	public String listFich (String dir) {
		
		File dFile= new File (dir);
		String [] list;
		String arch = "";

		
		
		if(dFile.isFile()) {
	
			
			 return "ARCHIVO"+"\nNombre: "+ dFile.getName()+
					 "\nExtensión: " +dFile.getName() +
					 "\nTamaño: "+dFile.getTotalSpace()+
					 "\nFecha creación: "+dFile.lastModified()+
					 "\nUbicación: "+dFile.getAbsolutePath();
		
		}
		else {
			
			list = dFile.list();
			
			
			for (String file : list) {
				
				arch+= file + "\n";
			}
			
			return arch;
			
		}
		
		
	}

}
