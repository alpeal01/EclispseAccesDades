package es.florida.AE01;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Modelo {

	public String[] listFich(String dir) {

		File dFile = new File(dir);
		String[] list;
		ArrayList <String> arch = new ArrayList <String>();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");	
		if (dFile.exists()) {
			if (dFile.isFile()) {

				String[] fName = dFile.getName().split("\\.");

				arch.add("ARCHIVO");
				arch.add("nNombre: " + fName[0]);
				arch.add( "Extensión: " + fName[1]);
				arch.add("Tamaño: "+ dFile.getTotalSpace()+ "bytes");
				arch.add("Fecha creación: " + df.format(dFile.lastModified()));
				arch.add("Ubicación: " + dFile.getAbsolutePath());
				
				
				
			}

			else {

				list = dFile.list();

				for (String file : list) {

					arch.add(file);
				}

				

			}

		} else {
			
			arch.add("Ruta no valida");
			
		}
		
		return arch.toArray(new String[0]);
		
	}

}
