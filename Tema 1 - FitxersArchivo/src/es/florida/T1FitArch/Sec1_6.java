package es.florida.T1FitArch;
import java.io.File;

//Modifica el programa anterior per que tinga en compte que si no se li passa ninguna extensió
//com a paràmetre, mostre tot el contingut del directori.

public class Sec1_6 {

	public static void main(String[] args) {
		
		File file = new File(args[0]);
		
		
		
		
			
			String [] lista  = file.list();
			
			
			if(args[1] == null ) {
				for (String data : lista) {
					
					System.out.println(data);
				}
				
			}else {
			
			for (String data : lista) {
				
				if(data.contains(args[1])){
					
					System.out.println(data);
					
				}
				
			}}
			
		
		
	}

}
