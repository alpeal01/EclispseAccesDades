package es.florida.T2Arch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class act8 {

	static int insertarPersonaje(Personaje ps) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ad_t2", "root", "");

			PreparedStatement psInsertar = con
					.prepareStatement("INSERT INTO personatges (nombre,vida, ataque, armadura)VALUES (?,?,?,?)");
			psInsertar.setString(1, ps.getNombre());
			psInsertar.setInt(2, ps.getVida());
			psInsertar.setInt(3, ps.getAtaque());
			psInsertar.setInt(4, ps.getArmadura());

			int resultadoInsertar = psInsertar.executeUpdate();
			return resultadoInsertar;

		} catch (Exception e) {

			e.printStackTrace();

		}
		return 0;

	}

	static int updatePer() {
		Scanner sc = new Scanner(System.in);
		String op;

		System.out.println("Indica ID a actualizar");
		int id = sc.nextInt();
		sc.nextLine();

		Personaje pers = new Personaje();
		String consulta = "UPDATE personatges SET nombre = '" + pers.getNombre() + "', vida = " + pers.getVida()
				+ ", ataque = " + pers.getAtaque() + ", armadura = " + pers.getArmadura() + " WHERE id = " + id + ";";

		System.out.println(consulta);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ad_t2", "root", "");
			PreparedStatement psActualizar = con.prepareStatement(consulta);

			System.out.println("Esta seguro que quiere actualizar S/N");
			op = sc.next();

			if (op.toLowerCase().equals("s")) {

				int resultadoActualizar = psActualizar.executeUpdate();
				sc.close();
				return resultadoActualizar;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		sc.close();
		return 0;

	}

	static int deletePers() {
		Scanner sc = new Scanner(System.in);
		String op;

		System.out.println("Indica ID a Borrar");
		int id = sc.nextInt();
		
		String consulta = "DELETE FROM personatges WHERE id = " + id + ";";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ad_t2", "root", "");
			PreparedStatement psBorrar = con.prepareStatement(consulta);

			System.out.println("Esta seguro que quiere eliminar! S/N");
			
			op = sc.nextLine();

			if (op.toLowerCase().equals("s")) {
				int resultadoBorrar = psBorrar.executeUpdate();
				sc.close();
				return resultadoBorrar;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		sc.close();
		return 0;

	}

	public static void main(String[] args) {

		// Personaje ps = new Personaje();

		// System.out.println(insertarPersonaje(ps));
		System.out.println(updatePer());
		// System.out.println(deletePers());
	}
}