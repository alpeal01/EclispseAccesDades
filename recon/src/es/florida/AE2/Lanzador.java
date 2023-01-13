package es.florida.AE2;

import java.io.File;
import java.io.IOException;

public class Lanzador {

	public static void main(String[] args) throws IOException {
		String clase = "es.florida.AE2";
		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classpath = System.getProperty("java.class.path");

		String className = "es.florida.AE2.Servidor";
		ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, className);
		builder.inheritIO().start();
		
		className = "es.florida.AE2.Cliente";
		builder = new ProcessBuilder(javaBin, "-cp", classpath, className);
		builder.inheritIO().start();

	}

}
