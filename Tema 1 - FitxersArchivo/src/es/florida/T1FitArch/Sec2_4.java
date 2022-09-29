package es.florida.T1FitArch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sec2_4 {
//Crea un programa que donat un fitxer de text, llija i mostre el seu contingut línia a línia.
	public static void main(String[] args) {
		
		File f = new File(args[0]);
		String line;
		
		try {
			FileReader fReader = new FileReader(f);
			
			BufferedReader buffReader = new BufferedReader(fReader);
			
			try {
				while((line = buffReader.readLine()) != null) {
					
					System.out.println(line);
					
				}
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
