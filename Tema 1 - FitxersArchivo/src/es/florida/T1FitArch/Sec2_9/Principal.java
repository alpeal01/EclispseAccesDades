package es.florida.T1FitArch.Sec2_9;

public class Principal {

	
	public static void main(String[] args) {
		
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(vista, modelo);
		
		
	}
}
