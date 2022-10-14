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

/**
 * @author Alvaro
 *
 */
public class Modelo {

	/**
	 * Lista el directiorio pasado por parametro y devuelve su contenido, si es un
	 * archivo de lectura mostrará su información.
	 * 
	 * @param dir el directorio dónde se encuentra el fichero
	 * @return String[] con los datos del fichero
	 */
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

	/**
	 * Lee el contenido de un archivo y lo vuelca en una variable
	 * 
	 * @param dir el directorio dónde se encuentra el archivo
	 * @return String con el contenido del archivo
	 */
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

	/**
	 * Inserta el contenido de un string dentro de un archivo de texto
	 * 
	 * @param text cadena de texto que desea introducir
	 * @param dir  dirección del archivo al que desea introducirle el texto
	 */
	public void guardarcCambios(String text, String dir) {

		File ruta = new File(dir);

		if (!ruta.exists()) {

			try {
				ruta.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

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

	/**
	 * @param text      El texto a encontrar y reemplazar
	 * @param palEnont  la palabra a reemplazar
	 * @param reemplazo la palbra por la que se reemplaza
	 * @return El texto con la palabra reemplazada
	 */
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
	/**
	 * 
	 * @param source a
	 * @param dest   b
	 * @throws IOException c
	 */
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
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			is.close();
			os.close();
		}
	}

	// copiar archivo por Alvaro;

	/**
	 * 
	 * @param ruta a
	 */
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

	/**
	 * Renombra el archivo elegido
	 * 
	 * @param dir     dirección del archivo que desea renombrar
	 * @param newName nombre que desea ponerle al archivo
	 */
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
