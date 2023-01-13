package es.florida.AE2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

public class Hilo implements Runnable {

	static Socket socket;
	static InputStream is;
	static InputStreamReader isr;
	static BufferedReader bfr;
	static OutputStream os;
	static PrintWriter pw;

	static String posi[] = { "", "", "", "", "", "", "", "", "" };

	public Hilo(Socket socket) {
		this.socket = socket;
	}

	public static void casoNumero() throws IOException {
		String decision = "";
		is = socket.getInputStream();
		isr = new InputStreamReader(is);
		bfr = new BufferedReader(isr);
		String resultado = bfr.readLine();
		System.err.println("SERVIDOR >>> Recibe decision mandada por el cliente: " + resultado);
		os = socket.getOutputStream();
		pw = new PrintWriter(os);

		int num = (int) (Math.random() * 10 + 1);
		System.err.println("Numero generado " + num);
		if (num % 2 == 0 && resultado.equals("PAR")) {
			decision = "CLIENTE";
			System.err.println("SERVIDOR >>> Servidor Envia la palabra clave: " + decision);
			pw.print(decision + "\n");
			pw.flush();
		} else if (num % 2 != 0 && resultado.equals("IMPAR")) {
			decision = "CLIENTE";
			System.err.println("SERVIDOR >>> Servidor Envia la palabra clave: " + decision);
			pw.print(decision + "\n");
			pw.flush();
		} else {

			decision = "SERVIDOR";
			int primerNumero = primeraTiradaServidor(decision);
			pw.print(primerNumero + "\n");
			System.err.println("SERVIDOR >>> la primera tirada SERVIDOR es: " + primerNumero);
			posi[primerNumero] = "O";
			System.err.println(Arrays.toString(posi));
			pw.flush();
		}
	}

	public static int primeraTiradaServidor(String server) {
		int num = (int) (Math.random() * 8);
		return num;
	}

	public static void guardaPosServidorPosi(int num) {
		posi[num] = "O";
	}

	public static void guardaPosCliente(int num) {
		System.err.println("Servidor gestiona envio de Cliente");
		posi[num] = "X";
		System.err.println(Arrays.toString(posi));
	}

	public static void posicionRandom() throws IOException {
		int bot = (int) (Math.random() * 8);
		if (!posi[bot].equals("")) {
			while (!posi[bot].equals("")) {
				bot = (int) (Math.random() * 8);
				posi[bot] = "O";
				break;//<--------
			}
		}
		
//		boolean intento = true;
//		int bot=0;
//		while (intento) {
//			while (!posi[bot].equals("")) {
//				bot = (int) (Math.random() * 8);
//				posi[bot] = "O";
//				intento=false;
//			}
//		}

		guardaPosServidorPosi(bot);
		os = socket.getOutputStream();
		pw = new PrintWriter(os);
		pw.print(bot + "\n");
		System.err.println("Servidor envia la posicion: " + bot);
		System.err.println(Arrays.toString(posi));
		pw.flush();
	}

	public void run() {
		try {
			casoNumero();
			while (true) {
				
				is = socket.getInputStream();
				isr = new InputStreamReader(is);
				bfr = new BufferedReader(isr);
				String resultado = bfr.readLine();
				System.err.println("CLIENTE >>> Ha enviado la posicion: " + resultado);
				int posCliente = Integer.parseInt(resultado);
				guardaPosCliente(posCliente);
				System.err.println("tablero al entrar"+Arrays.toString(posi));
				posicionRandom();
				System.err.println("tablero al salir"+Arrays.toString(posi));
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " >>> Error.");
		}

	}

}
