package es.florida.AE01;

import java.io.File;
import java.text.SimpleDateFormat;

public class Modelo {

	public String listFich(String dir) {

		File dFile = new File(dir);
		String[] list;
		String arch = "";
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

		if (dFile.exists()) {
			if (dFile.isFile()) {

<<<<<<< HEAD
				String[] fName = dFile.getName().split("\\.");
			;
=======
			

			 return "ARCHIVO"+"\nNombre: "+ fName[0]+
					 "\nExtensión: " +fName[1] +
					 "\nTamaño: "+dFile.getTotalSpace()+" bytes"+
					 "\nFecha creación: "+ df.format(dFile.lastModified())+
					 "\nUbicación: "+dFile.getAbsolutePath();
		
		}
		else {
			
			list = dFile.list();
			
			
			for (String file : list) {
>>>>>>> d5ff64e3cf3cfd545b9607ec1cde52d24aa261b6
				
				return "ARCHIVO" + "\nNombre: " + fName[0] + "\nExtensión: " + fName[1] + "\nTamaño: "
						+ dFile.getTotalSpace() + " bytes"+"\nFecha creación: " + df.format(dFile.lastModified())
						+ "\nUbicación: " + dFile.getAbsolutePath();

			} else {

				list = dFile.list();

				for (String file : list) {

					arch += file + "\n";
				}

				return arch;

			}

		} else {
			return "Ruta no existe";
		}
	}

}
