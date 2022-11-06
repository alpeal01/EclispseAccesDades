package es.florida.aev2;

import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Controlador {
	private Vista vista;
	private Model modelo;

	// El constructor rep instancia de la vista i del Model

	public Controlador(Vista vista, Model modelo) throws HeadlessException, NoSuchAlgorithmException, UnsupportedEncodingException {
		this.vista = vista;
		this.modelo = modelo;
		initEventHandlers();

	}

	public void initEventHandlers() throws HeadlessException, NoSuchAlgorithmException, UnsupportedEncodingException {
//		vista."NomdeLboto".addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent arg0) {
//		 //Codi que s’executa en pulsar el botó acceptar
//		}
//		});
		// Afegir tants gestors com acción vulga realitzar
		modelo.controlLogin();
	}
}