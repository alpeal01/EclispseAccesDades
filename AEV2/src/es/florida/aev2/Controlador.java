package es.florida.aev2;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
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
		boolean login = true;
//		vista."NomdeLboto".addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent arg0) {
//		 //Codi que s’executa en pulsar el botó acceptar
//		}
//		});
		// Afegir tants gestors com acción vulga realitzar
		// modelo.controlLogin();

		JTextField username = new JTextField();
		JTextField password = new JPasswordField();
		
		while(login) {
		Object[] message = { "Username:", username, "Password:", password };
		int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
		System.out.println(option);
		if(modelo.compUser(username.getText(), modelo.convertPassword(password.getText())) && option == 0) {
			
			login = false;
			
		}else if(option == -1 ||option == 2 ) {
			
			login = false;
		}
		
		
		}
		vista.getBtnExecutar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					vista.txtResultats.setText( modelo.exConsulta(vista.getTxtQuery().getText()));
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
		
		vista.getBtnShowT().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.txtResultats.setText(modelo.dbStruc());
			}
		});
		
		vista.getBtnShowInfo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.txtResultats.setText(modelo.describeTable(vista.getTxtQuery().getText()));
			}
		});

	}
}