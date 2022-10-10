package es.florida.AE01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controlador {
	private Vista vista;
	private Modelo modelo;

	// El constructor rep instancia de la vista i del Modelo
	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		initEventHandlers();
	}

	// Mètode per afegir els listeners als elements que els generen (botons)
	public void initEventHandlers() {

		vista.getBtnBusq().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				vista.getList().setListData(modelo.listFich(vista.getTxtBusq().getText()));
				
				vista.getTxtArMost().setText(modelo.cargaContendio(vista.getTxtBusq().getText()));
				

			}

		});

	}

	/*
	 * public void iniciarVista() { vista = new Vista(); vista.setVisible(true); }
	 */

}
