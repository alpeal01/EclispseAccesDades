package es.florida.T2Arch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class act5 {
	
	
	static int insertarPersonaje (Personaje ps) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ad_t2","root","");
				
			PreparedStatement psInsertar = con.prepareStatement("INSERT INTO personatges (nombre,vida, ataque, armadura)VALUES (?,?,?,?)");
					psInsertar.setString(1,ps.getNombre());
					psInsertar.setInt(2,ps.getVida());
					psInsertar.setInt(3,ps.getAtaque());
					psInsertar.setInt(4,ps.getArmadura());
					
					int resultadoInsertar = psInsertar.executeUpdate();
					return resultadoInsertar;
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		return 0;
		
	}

	public static void main(String[] args) {
		
		Personaje ps = new Personaje();
		
		System.out.println(insertarPersonaje(ps));


	}

}