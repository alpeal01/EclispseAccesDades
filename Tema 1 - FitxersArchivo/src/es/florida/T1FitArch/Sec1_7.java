package es.florida.T1FitArch;

import java.io.File;
import java.io.FilenameFilter;


public class Sec1_7 {
	public static void main(String[] args) {

		/*
		 * Modifica el programa anterior per tal que admeta com a paràmetres d’entrada
		 * un nombre qualsevol d’extensions, tornant després per pantalla tots els
		 * fitxers del directori que tinguen alguna de les extensions indicades
		 */
	
		File file = new File(args[0]);
		
		String lista[];
		
		try {
			lista = file.list(new FilenameFilter() {
				
				public boolean accept(File dir, String name) {
					boolean extend = false;
					for (int i = 1; i < args.length; i++) {

						if (name.endsWith(args[i])) {
							extend = true;

					}
						

				}
					return extend;
					}
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
			lista = file.list();
		}
		System.out.println("Resultados: " + lista.length);
		for (String data : lista) {

			System.out.println(data);

		}

	}

}
