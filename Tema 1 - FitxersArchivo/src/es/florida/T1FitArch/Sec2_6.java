package es.florida.T1FitArch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Sec2_6 {

	/*
	 * Crea un altre programa a partir de l’anterior que en comptes de mostrar el
	 * contingut per consola l’escriga en un altre fitxer del mateix directori.
	 */
	public static void main(String[] args) {

		File f = new File(args[0]);
		String line;
		String lines="";
		
		try {
			FileReader fReader = new FileReader(f);

			BufferedReader buffReader = new BufferedReader(fReader);

			try {
				while( (  line = buffReader.readLine())!= null) {
							
						lines += line + "\n";
				}
				
				buffReader.close();
				fReader.close();
				
				File copFile = new File(f.getParent() + "/copy.txt");
				
				copFile.createNewFile();
				
				
				FileWriter fWriter = new FileWriter(copFile);
				BufferedWriter buffWriter = new BufferedWriter(fWriter);
				
				buffWriter.write(lines);
				
				buffWriter.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
