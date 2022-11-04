package es.florida.T2Arch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class act9 {

	static void mostrarLLibrers() {
		
		String result = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ad_t2","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM llibres;"); 
			if(con.isValid(0)) {
				System.out.println("Conexion establecida con exito");
				System.out.println("-------------------------------");
			}else {
				System.out.println("Error en la conexion SQL");
			}
			while(rs.next()) {
				
				
				for(int i = 1;i <= rs.getMetaData().getColumnCount(); i++) {
					
					
					result += rs.getString(i) + " ";
					
				}
				result += "\n";
				
				
			}
			
			System.out.println(result);
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	
		
		
	}
	static ArrayList <Llibre> exportCSV() {
		File f = new File("./Exercicis_T2_MySQL_Dades.csv");
		String line;
		ArrayList <Llibre> list = new ArrayList <Llibre>();
		String [] lib;
		
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
		br.readLine();
			while((line = br.readLine()) != null) {
				lib = line.split(";");
				list.add(new Llibre(lib[0],lib[1],lib[2],lib[3],lib[4],lib[5]));
				
				
				//System.out.println(lib[0]+lib[1]+lib[2]+lib[3]+lib[4]+lib[5]);
				
			}
			
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
		
	}
	
	static void insertarLibs(ArrayList <Llibre> libs) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ad_t2","root","");
			
			for (Llibre llibre : libs) {
				
			
				
			PreparedStatement psInsertar = con.prepareStatement("INSERT INTO llibres (titol,autor,any_public, any_nac,editorial,numPag)VALUES (?,?,?,?,?,?)");
					psInsertar.setString(1,llibre.getTitol());
					psInsertar.setString(2,llibre.getAutor());
					psInsertar.setString(3,llibre.getAny_public());
					psInsertar.setString(4,llibre.getAnt_nac());
					psInsertar.setString(5,llibre.getEditiorial());
					psInsertar.setString(6,llibre.getNumpag());
					
					psInsertar.executeUpdate();
					
			}
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <Llibre> list = exportCSV ();
		insertarLibs(list);
		mostrarLLibrers();
		
		

	}

}
