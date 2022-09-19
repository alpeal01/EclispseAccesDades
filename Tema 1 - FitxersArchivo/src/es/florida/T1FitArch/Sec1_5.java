package es.florida.T1FitArch;
import java.io.File;
import java.io.FilenameFilter;

public class Sec1_5 {
	//5 Realitza un programa que reba com a paràmetres d’entrada un directori i una extensió de
	//fitxer (por exemple .txt) i torne per pantalla tots els fitxers del directori que complisquen el
	//criteri.
	public static void main(String[] args) {
		
		File file = new File(args[0]);
	
		
		
		
		String[] lista = file.list(new FilenameFilter() {
		    @Override
		    public boolean accept(File dir, String name) {
		        return name.endsWith(args[1]);
		    }
		});
		System.out.println("Resultados: "+ lista.length);
			for (String data : lista) {
				
					
				
					System.out.println(data);
					
				}
				
			
			
		
		
		
		
	}
}
