package es.florida.T1FitArch;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Sec1_9 {
	static void getInformacio(File f) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		String mostrar;
		System.out.println("-----Listado-----");

		mostrar = "";

		mostrar += f.getName();

		if (f.isDirectory()) {
			mostrar += "\nDirectorio: ";

			String[] l = f.list();

			for (String arch : l) {

				mostrar += arch + "|";
			}

			mostrar += "\nFree Space: " + f.getFreeSpace();
			mostrar += "\nTotal Space: " + f.getTotalSpace();

		} else {
			mostrar += "\nArchivo " + "size: " + f.getTotalSpace();
		}

		mostrar += "\n" + f.getAbsolutePath();

		mostrar += "\nLast modified:  " + df.format(f.lastModified());

		if (f.isHidden()) {
			mostrar += "\n" + " Oculto";
		} else
			mostrar += "\n" + "Visible";

		System.out.println(mostrar);
		

	}

	static File creaCarpeta(File f) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica nombre carpta: ");
		String nameC = sc.nextLine();

		File carp = new File(f.getAbsolutePath() + "/" + nameC);

		if (carp.mkdir()) {

			System.out.println("Carpeta creada");

		} else {
			System.out.println("La ruta no es un directorio");
		}
		
		
		return carp;
	}

	static void creaFitxer(File lastCarp) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Indica nombre del archivo");
		String nameA = sc.nextLine();

		File carp = new File(lastCarp.getAbsolutePath() + "/" + nameA);

		try {
			if (carp.createNewFile()) {

				System.out.println("Archivo creado");

			} else {
				System.out.println("Error en la ruta");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	static void elimina(File f) {
		
		f.delete();

	}

	static void renomena(File f) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica nombre nuevo");
		String newName = sc.nextLine();
		
		File newDir = new File(f.getParent() + "/" + newName);
		
		f.renameTo(newDir);
		System.out.println("Archivo renombrado");
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		File lastCarp = new File("Null");

		File f = new File(args[0]);
	

		boolean loop = true;
		int op;

		do {

			System.out.println("------Menu-----");
			System.out.println("1) Informacion");
			System.out.println("2) Crear Carpeta");
			System.out.println("3) Crear Fichero en " + "Carpeta: " + lastCarp.getName());
			System.out.println("4) Eliminar Fichero");
			System.out.println("5) Renombrar Fichero");
			System.out.println("6) Cerrar");

			op = sc.nextInt();

			switch (op) {
			case 1: {

				getInformacio(f);
				break;

			}
			case 2: {

				lastCarp = creaCarpeta(f);
				break;

			}
			case 3: {
				creaFitxer(lastCarp);
				break;
			}
			case 4: {
				elimina(f);
				break;
			}
			case 5: {
				renomena(f);
				break;
			}
			case 6: {
				loop = false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + op);
			}

		} while (loop);
		sc.close();
	}

}
