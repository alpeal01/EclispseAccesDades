package es.florida.AE01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Modelo {

	// Lista el directiorio pasado por parametro y devuelve su contenido, si es un
	// archivo de lectura mostrará
	// su información.
	public String[] listFich(String dir) {

		File dFile = new File(dir);
		String[] list;
		ArrayList<String> arch = new ArrayList<String>();
		// Añadido esta condición para la el botón de reiniciar, con este arreglo y con la función de buscar, el JList nos dice que es nulo si queremos hacer otra búsqueda || Héctor
		if (dir.isBlank()) {
			arch.add(" ");
		} else {
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

	public void guardarcCambios(String text, String dir) {

		File ruta = new File(dir);

		if (ruta.isFile()) {

			FileWriter fw;
			try {
				fw = new FileWriter(ruta);

				BufferedWriter buffWrite = new BufferedWriter(fw);

				buffWrite.write(text);

				buffWrite.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public String reemplazar(String text, String palEnont, String reemplazo) {

		String[] list = text.split(" ");
		String newText = "";

		for (String word : list) {

			if (word.equals(palEnont)) {

				newText += reemplazo + " ";

			} else
				newText += word + " ";

		}

		return newText;

	}

	// Copiar archivos por Héctor
	public static void copiarArch(File source, File dest) throws IOException {

		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;

			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			is.close();
			os.close();
		}
	}

	// copiar archivo por Álvaro;

	public void dupliArch(String ruta) {

		File dir = new File(ruta);
		String content = "";
		String line;

		if (dir.isFile()) {

			FileReader fr;
			try {
				fr = new FileReader(dir);
				BufferedReader buffRead = new BufferedReader(fr);

				while ((line = buffRead.readLine()) != null) {

					content += line;

				}
				buffRead.close();
				fr.close();

				dir = new File(dir.getParent() + "/" + dir.getName() + " copia");

				dir.createNewFile();

				FileWriter fw = new FileWriter(dir);

				BufferedWriter buffWrite = new BufferedWriter(fw);

				buffWrite.write(content);

				buffWrite.close();
				fw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void renombArch(String dir, String newName) {

		File file = new File(dir);

		if (file.isFile()) {

			File newDir = new File(file.getParent() + "/" + newName);

			System.out.println(newDir.getAbsolutePath());

			file.renameTo(newDir);
			// ./Archivos/
		}

	}
}
