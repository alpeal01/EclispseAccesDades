package es.florida.T1FitArch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sec2_5 {

	/*
	 * 5 Modifica el programa anterior per a que accepte com a paràmetres d’entrada
	 * un nombre que indique la velocitat a la qual es mostren les línies.
	 */
	public static void main(String[] args) {

		File f = new File(args[0]);
		String line;

		try {
			FileReader fReader = new FileReader(f);

			BufferedReader buffReader = new BufferedReader(fReader);

			try {
			line = buffReader.readLine();
			
			System.out.println(line);
					
			buffReader.close();

					

				
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
