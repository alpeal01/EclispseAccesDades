package es.florida.T1FitArch;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.*;
import javax.xml.parsers.*;

public class Sec3_7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Personaje> persList = new ArrayList<Personaje>();
		
		 boolean op = true;
		 String res;
		 
		 do {
			 
			 persList.add(new Personaje());
			 System.out.println("Quiere ingresa otro personaje S/N");
			 res = sc.nextLine();
			 if(res.toLowerCase().equals("n")) {
				 op = false;
			 }
			
			 
			 
		 }while(op);
		 
		 sc.close();
		

	}

}