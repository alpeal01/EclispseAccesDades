package es.florida.AE01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Modelo {

	// Lista el directiorio pasado por parametro y devuelve su contenido, si es un
	// archvio de lectura mostrara
	// su información.
	public String[] listFich(String dir) {

		File dFile = new File(dir);
		String[] list;
		ArrayList<String> arch = new ArrayList<String>();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		if (dFile.exists()) {
			if (dFile.isFile()) {

				String[] fName = dFile.getName().split("\\.");

				arch.add("ARCHIVO");
				arch.add("Nombre: " + fName[0]);
				arch.add("Extensión: " + fName[1]);
				arch.add("Tamaño: " + dFile.getTotalSpace() + "bytes");
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

	public String cargaContendio(String dir) {

		File file = new File(dir);
		
		
		if (file.exists()) {
			if (file.isFile()) {

				try {
					FileReader fileRead = new FileReader(file);

					BufferedReader buffReader = new BufferedReader(fileRead);

					String line;
					String lines = "";

					while ((line = buffReader.readLine()) != null) {

						lines += line;
						lines += "\n";

					}
					buffReader.close();
					fileRead.close();
					return lines;

				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

		return "";

	}

}
