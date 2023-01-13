package es.florida.AE2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {

	public static void main(String[] args) throws IOException, InterruptedException {

		int numeroPuerto = 1234;
		ServerSocket servidor = new ServerSocket(numeroPuerto);

		while (true) {
			Socket conexion = servidor.accept();
			System.err.println("SERVIDOR >>> Conexion recibida ---> Lanza hilo");
			Hilo h = new Hilo(conexion);
			Thread hilo = new Thread(h);
			hilo.start();
		}

	}

}
