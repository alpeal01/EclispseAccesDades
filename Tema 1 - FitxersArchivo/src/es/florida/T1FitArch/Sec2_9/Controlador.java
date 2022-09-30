package es.florida.T1FitArch.Sec2_9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {
	private Vista vista;
	private Modelo Modelo;
	//El constructor rep instancia de la vista i del Modelo
	public Controlador (Vista vista, Modelo Modelo){
	this.vista = vista;
	this.Modelo = Modelo;
	initEventHandlers();
	}
	//Mètode per afegir els listeners als elements que els generen (botons)
	public void initEventHandlers() {
		System.out.println("consola");
		vista.getBtnCargar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.getTxtMostrar().setText("Hola mundo");
				System.out.println("consola");
			}
		});
	}
		
		
			
		
		/*
	public void iniciarVista() {
		vista = new Vista();
		vista.setVisible(true);
	}
	*/
	
	
}

