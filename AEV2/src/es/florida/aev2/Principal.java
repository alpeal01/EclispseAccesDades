package es.florida.aev2;



public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vista vista = new Vista();
		Model modelo = new Model();
		Controlador controlador = new Controlador(vista, modelo);
	
		
		
	}

}