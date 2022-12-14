package es.florida.T1FitArch.Sec2_9;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Vista extends JFrame {

	JPanel contentPane;
	JTextField txtBuscar;
	JTextField txtReemplazar;
	JTextField txtDir;
	JButton btnCargar;
	JTextArea txtArMostrar;
	JTextArea txtArRem;
	JButton btnRemplazar;
	JButton btnBuscar;

	public JButton getBtnCargar() {
		return btnCargar;
	}

	public JTextField gettxtDir() {
		return txtDir;
	};

	public JTextArea getTxtArMostrar() {
		return txtArMostrar;
	};
	
	public JTextArea getTxtArRem() {
		return txtArRem;
	};
	
	public JButton getBtnRemplazar() {
		return btnRemplazar;
	}
	public JTextField getTxtReemplazar() {
		return txtReemplazar;
	}
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	
	public JTextField getTxtBuscar() {
		return txtBuscar;
	}
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtBuscar = new JTextField();
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(96, 202, 125, 19);
		contentPane.add(txtBuscar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(231, 201, 85, 21);
		contentPane.add(btnBuscar);

		txtReemplazar = new JTextField();
		txtReemplazar.setColumns(10);
		txtReemplazar.setBounds(390, 202, 141, 19);
		contentPane.add(txtReemplazar);

		btnRemplazar = new JButton("Reemplazar");
		btnRemplazar.setBounds(541, 201, 103, 21);
		contentPane.add(btnRemplazar);

		txtDir = new JTextField();
		txtDir.setColumns(10);
		txtDir.setBounds(96, 418, 125, 19);
		contentPane.add(txtDir);

		btnCargar = new JButton("Cargar Archivo");

		btnCargar.setBounds(231, 418, 125, 21);
		contentPane.add(btnCargar);

		txtArMostrar = new JTextArea();
		txtArMostrar.setEditable(false);
		txtArMostrar.setBounds(96, 11, 548, 180);
		contentPane.add(txtArMostrar);
		
		txtArRem = new JTextArea();
		txtArRem.setEditable(false);
		txtArRem.setBounds(96, 232, 548, 180);
		contentPane.add(txtArRem);
		this.setVisible(true);
	}
}
