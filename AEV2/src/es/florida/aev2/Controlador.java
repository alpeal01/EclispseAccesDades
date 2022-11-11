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
				String orden = vista.getTxtQuery().getText().split(" ")[0];
				 int dialogButton = JOptionPane.YES_NO_OPTION;
				 String result;
				
				if(orden.toUpperCase().equals("SELECT")) {
				
				vista.txtResultats.setText( modelo.exConsulta(vista.getTxtQuery().getText(),true));
				}
				else if (orden.toUpperCase().equals("INSERT") || orden.toUpperCase().equals("DELETE") ||  orden.toUpperCase().equals("UPDATE")) {
					
					int dialogResult = JOptionPane.showConfirmDialog (null, "Estas segur de realitzar esta ordre","Perill!",dialogButton);
					if(dialogResult == JOptionPane.YES_OPTION){
						
						result = modelo.exConsulta(vista.getTxtQuery().getText(),false);
						
						vista.txtResultats.setText(result);
						
						
					 
					}else {
						vista.txtResultats.setText("Operació no realitzada");
					}
					
				}
				else {
					vista.txtResultats.setText("Ordre no admitida");
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