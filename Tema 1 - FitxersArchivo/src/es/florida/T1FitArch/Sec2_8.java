package es.florida.T1FitArch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Sec2_8 {

	/*
	 * Realitza un programa que permeta rebre per teclat una sèrie de strings per
	 * part de l’usuari i els vaja escrivint en un fitxer de text. Com a condició de
	 * finalització, l’usuari haurà d’escriure un string que siga “exit”.
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String line;
		String text = "";
		Date dt = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd_MM_yy HH_mm_ss");
		String newArch = "./test/" + "Sec2_7 " + df.format(dt) + ".txt";

		File dir = new File(newArch);

		do {

			line = sc.nextLine();

			if (!line.equals("exit")) {

				text += line + "\n";

			}

		} while (!line.equals("exit"));

		if (text.length() > 0) {

			try {
				dir.createNewFile();

				FileWriter fileWrite = new FileWriter(dir);
				BufferedWriter buffWrite = new BufferedWriter(fileWrite);

				buffWrite.write(text);

				buffWrite.close();
				fileWrite.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		sc.close();
		

	}
}
