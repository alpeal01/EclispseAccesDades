package es.florida.aev2;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Controlador {
	private Vista vista;
	private Model modelo;

	// El constructor rep instancia de la vista i del Model

	public Controlador(Vista vista, Model modelo)
			throws HeadlessException, NoSuchAlgorithmException, UnsupportedEncodingException {
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
		// modelo.controlLogin();

		JTextField username = new JTextField();
		JTextField password = new JPasswordField();
		Object[] message = { "Username:", username, "Password:", password };
		int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
		modelo.compUser(username.getText(), modelo.convertPassword(password.getText()));

		vista.getBtnExecutar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					vista.txtResultats.add(null, modelo.exConsulta(vista.getTxtQuery().getText()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		vista.getBtnObrir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.dbConnect();
			}
		});

		vista.getBtnTancar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.dbDisconnect();
			}
		});

	}
}