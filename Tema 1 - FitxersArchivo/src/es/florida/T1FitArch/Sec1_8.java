package es.florida.T1FitArch;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Sec1_8 {

	public static void main(String[] args) {
		
		File f = new File(args[0]);
		//String name;
		//String ruta;
	
		
		try {
		if(f.createNewFile()) {
			System.out.println("File not exist");
			
			
		}else {
			
			System.out.println("File exist");
//			name = f.getName();
//			name += "(copia)";
//			ruta = f.getParent();
//			ruta += "/"+ name;
//		
//			f = new File(ruta);
//			System.out.println("Creando copia en: "+ ruta);
//			f.createNewFile();
//			
//			f.delete();
//			System.out.println("Eliminando la copia");
			
			FileReader read = new FileReader (f);
			BufferedReader bfReader = new BufferedReader(read);
			
			
			String line = bfReader.readLine();
			
			bfReader.close();
			read.close();
			
			System.out.println(line);
			
			String ruta = f.getParent()+"/copia";
			
			File copy = new File(ruta);
			
			copy.createNewFile();
			
			FileWriter fWriter = new FileWriter(copy);
			
			BufferedWriter bfWriter = new BufferedWriter(fWriter);
			
			bfWriter.write(line);
			
			
			bfWriter.close();
			
			fWriter.close();
	
			
			
		}}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
