package es.florida.T1FitArch;

import java.io.File;

public class Sec1_2 {
	public static void main(String[] args) {

		File f = new File(args[0]);

		String[] lista = f.list();

		for (String data : lista) {

			System.out.println(data);

		}

	}

}
