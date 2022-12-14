package es.florida.T1FitArch.Sec2_9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Modelo {

	public Modelo() {
	}

	public String cargarArchivo(String dir) {

		String text = "";
		String line;
		try {
			FileReader fr = new FileReader(dir);

			BufferedReader bfr = new BufferedReader(fr);

			while ((line = bfr.readLine()) != null) {
				text += line;
				text += "\n";
			}

			bfr.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return (text);

	}

	public int countWord(String text, String word) {

		String[] list = text.split(" ");
		int count = 0;

		for (String letter : list) {

			if (letter.equals(word)) {
				count++;
			}

		}
		return count;

	}

	public String reemText(String text, String bWord, String rWord, String dir) {

		String[] list = text.split(" ");
		String newText = "";

		for (int i = 0; i < list.length; i++) {

			if (list[i].equals(bWord)) {
				list[i] = rWord;
			}

			newText += list[i] + " ";
		}
		File fdir = new File(dir);

		writeText(fdir, newText);

		return newText;
	}

	void writeText(File f, String text) {

		String dir;
		try {
			dir = f.getParent();

			dir += "/" + "copia.txt";

			f = new File(dir);

			f.createNewFile();

			FileWriter fw = new FileWriter(f);

			BufferedWriter bfw = new BufferedWriter(fw);

			bfw.write(text);
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
