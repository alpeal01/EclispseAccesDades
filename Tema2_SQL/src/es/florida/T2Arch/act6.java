package es.florida.T2Arch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class act6 {
//Implementa un mètode que permeta, donat un id de la taula, actualitzar algun dels seus
	//camps (el nou valor del camp s’introduirà per teclat).
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
	static  int updatePer() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Indica ID a actualizar");
		int id = sc.nextInt();
		
		Personaje pers = new Personaje();
		String consulta = "UPDATE personatges SET nombre = '"+ pers.getNombre() 
		+"', vida = "+pers.getVida()+", ataque = "+pers.getAtaque()+", armadura = "+ pers.getArmadura()+
		" WHERE id = " + id+";";
		
		System.out.println(consulta);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ad_t2","root","");
			PreparedStatement psActualizar = con.prepareStatement(consulta);
			
			int resultadoActualizar = psActualizar.executeUpdate();
			return resultadoActualizar;

			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return 0;
		
		
	}

	public static void main(String[] args) {
		
		//Personaje ps = new Personaje();
		
		//System.out.println(insertarPersonaje(ps));
		System.out.println(updatePer());

	}
}
