package es.florida.T1FitArch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sec2_2 {

	public static void main(String[] args) {
		
		boolean loop = true;
		
		File dir = new File(args[0]);
		
		int carct;
		
		try {
			FileReader read = new FileReader(dir);
			
			try {
				while(loop) {

					carct = read.read();
				
					if(carct == -1) {
						loop = false;
					}else {
						
						System.out.print((char)carct);
					}
					
					try {
						Thread.sleep( Integer.parseInt(args[1]) );
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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