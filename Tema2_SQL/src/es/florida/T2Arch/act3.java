package es.florida.T2Arch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class act3 {

	public static void main(String[] args) {
		String result = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ad_t2","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM personatges;"); 
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

}