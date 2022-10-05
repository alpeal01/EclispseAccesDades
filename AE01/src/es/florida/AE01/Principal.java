package es.florida.AE01;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(vista, modelo);
	
		
		
	}

}
