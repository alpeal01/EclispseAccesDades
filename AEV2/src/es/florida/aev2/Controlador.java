package es.florida.aev2;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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
	
	  void userCon() {
		
		JTextField username = new JTextField();
		JTextField password = new JPasswordField();
		boolean login = true;
		try {
		while (login) {
			Object[] message = { "Username:", username, "Password:", password };
			int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
			System.out.println(option);
			if (modelo.compUser(username.getText(), modelo.convertPassword(password.getText())) && option == 0) {

				login = false;

			} else if (option == -1 || option == 2) {

				login = false;
				vista.dispatchEvent(new WindowEvent(vista, WindowEvent.WINDOW_CLOSING));

			}

		}
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}
		
		
		
	}

	public void initEventHandlers() throws HeadlessException, NoSuchAlgorithmException, UnsupportedEncodingException {

		
//		vista."NomdeLboto".addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent arg0) {
//		 //Codi que s’executa en pulsar el botó acceptar
//		}
//		});
		// Afegir tants gestors com acción vulga realitzar
		// modelo.controlLogin();

		userCon();
		
		vista.getBtnExecutar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String orden = vista.getTxtQuery().getText().split(" ")[0];
				int dialogButton = JOptionPane.YES_NO_OPTION;
				String result;

				if (orden.toUpperCase().equals("SELECT")) {

					vista.txtResultats.setText(modelo.exConsulta(vista.getTxtQuery().getText(), true));
				} else if (orden.toUpperCase().equals("INSERT") || orden.toUpperCase().equals("DELETE")
						|| orden.toUpperCase().equals("UPDATE")) {

					int dialogResult = JOptionPane.showConfirmDialog(null, "Estas segur de realitzar esta ordre",
							"Perill!", dialogButton);
					if (dialogResult == JOptionPane.YES_OPTION) {

						result = modelo.exConsulta(vista.getTxtQuery().getText(), false);

						vista.txtResultats.setText(result);

					} else {
						vista.txtResultats.setText("Operació no realitzada");
					}

				} else {
					vista.txtResultats.setText("Ordre no admitida");
				}
			}
		});

		vista.getBtnObrir().addActionListener(new ActionListener() {
			String resultad;
			
			public void actionPerformed(ActionEvent e) {
				userCon();
				resultad = modelo.dbConnect();
				JOptionPane.showMessageDialog(null, resultad, "InfoBox: " + "Conexió DB!",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		vista.getBtnTancar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Tancar la conexion preguntant al usuari

				int result = JOptionPane.showConfirmDialog(vista, "Estas segur de tancar la conexió", "Tancar conexió",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (result == JOptionPane.YES_OPTION) {
					modelo.dbDisconnect();
					vista.txtResultats.setText("Conexió tancada correctament");

				}
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