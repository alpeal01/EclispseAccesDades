package es.florida.T1FitArch.Sec2_9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Modelo {

	
	public Modelo() {}
	
	
	public  String cargarArchivo(String dir) {
		
		String text = "";
		String line;
		try {
			FileReader fr = new FileReader(dir);
			
			BufferedReader bfr = new BufferedReader(fr);
			
			
			
			while((line = bfr.readLine())!=null) {
				text+= line;
				text += "\n";
			}
			
			bfr.close();
			

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return (text);
		
		
	}
	
	public  int countWord(String text,String word) {
		
		String [] list = text.split(" ");
		int count = 0;
		
		for (String letter : list) {
			
			if(letter.equals(word)) {
				count++;
			}
			
		}
		return count;
		
		
	}
	
	public  String reemText(String text,String bWord,String rWord) {
		
		String [] list = text.split(" ");
		String newText = "";
		
		for (int i = 0; i < list.length;i++) {
			
			if(list[i].equals(bWord) ) {
				list[i]= rWord;
			}
			
			newText+= list[i] + " ";
		}
		return newText;
	}
	
	
}
