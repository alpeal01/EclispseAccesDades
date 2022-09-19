
 package es.florida.T1FitArch;
import java.io.File;
import java.io.FilenameFilter;

public class Sec1_6 {
//Modifica el programa anterior per que tinga en compte que si no se li passa ninguna extensió
//com a paràmetre, mostre tot el contingut del directori.
	public static void main(String[] args) {
		
		File file = new File(args[0]);
		String lista[];
		try {
		 lista = file.list(new FilenameFilter() {
		    @Override
		    public boolean accept(File dir, String name) {
		        return name.endsWith(args[1]);
		    }
		});}catch (Exception e) {
			System.out.println(e.getMessage());
			 lista = file.list();
		}
		System.out.println("Resultados: "+ lista.length);
			for (String data : lista) {
				
					
				
					System.out.println(data);
					
				}
		
	}
}
