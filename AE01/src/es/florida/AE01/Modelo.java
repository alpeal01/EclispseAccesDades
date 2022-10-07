package es.florida.AE01;

import java.io.File;
import java.text.SimpleDateFormat;

public class Modelo {
	
	
	public String listFich (String dir) {
		
		File dFile= new File (dir);
		String [] list;
		String arch = "";
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

		
		
		if(dFile.isFile()) {
				
			String[] fName; 
		
			String name = dFile.getName();
			
			fName = name.split("\\.");
			
			
		
			
			 return "ARCHIVO"+"\nNombre: "+ dFile.getName()+
					 "\nExtensión: " +dFile.getName() +
					 "\nTamaño: "+dFile.getTotalSpace()+
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
		
		
	}

}
