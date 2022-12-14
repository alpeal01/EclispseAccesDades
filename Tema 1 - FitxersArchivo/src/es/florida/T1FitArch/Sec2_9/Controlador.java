package es.florida.T1FitArch.Sec2_9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
		
		vista.getBtnCargar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.getTxtArMostrar().setText(modelo.cargarArchivo(vista.gettxtDir().getText()));
			}

		});
		vista.getBtnBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = modelo.countWord(modelo.cargarArchivo(vista.gettxtDir().getText()), vista.getTxtBuscar().getText());
				
				JOptionPane.showMessageDialog(null, count + " palabras encontradas" , "InfoBox: " + "Contador de busqueda", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		
		vista.getBtnRemplazar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vista.getTxtArRem().setText(modelo.reemText(modelo.cargarArchivo(vista.gettxtDir().getText()), vista.getTxtBuscar().getText(),vista.getTxtReemplazar().getText(),vista.gettxtDir().getText()));
				
			}
		}
				);

	}

	/*
	 * public void iniciarVista() { vista = new Vista(); vista.setVisible(true); }
	 */

}
