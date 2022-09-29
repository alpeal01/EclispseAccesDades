package es.florida.T1FitArch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Sec2_3 {

	public static void main(String[] args) {

		boolean loop = true;
		
		Scanner sc = new Scanner(System.in);
		

		File dir = new File(args[0]);

		int carct;
		int i = 0;

		try {
			FileReader read = new FileReader(dir);

			try {
				while (loop) {

					carct = read.read();

					if (carct == -1) {
						loop = false;
					} else {

						if (i == 100) {
							sc.nextLine();
							i = 0;
						} else {
							System.out.print((char) carct);
							i++;
						}

					}

				}
				read.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

}
