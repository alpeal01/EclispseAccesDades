package es.florida.T1FitArch;
import java.io.File;

public class Sec1_8 {

	public static void main(String[] args) {
		
		File f = new File(args[0]);
		String name;
		String ruta;
	
		
		try {
		if(f.createNewFile()) {
			System.out.println("File not exist");
			
			
		}else {
			System.out.println("File exist");
			name = f.getName();
			name += "(copia)";
			ruta = f.getParent();
			ruta += "/"+ name;
		
			f = new File(ruta);
			System.out.println("Creando copia en: "+ ruta);
			f.createNewFile();
			
			f.delete();
			System.out.println("Eliminando la copia");
			
			
		}}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
