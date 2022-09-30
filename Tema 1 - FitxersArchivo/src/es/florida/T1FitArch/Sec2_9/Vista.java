package es.florida.T1FitArch.Sec2_9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Vista extends JFrame {

	 JPanel contentPane;
	 JTextField txtMostrar;
	 JTextField txtBuscar;
	 JTextField txtReemplazar;
	 JTextField txtResultant;
	 JTextField txtDir;
	 JButton btnCargar;
	 
	  public JButton getBtnCargar() { return btnCargar; }
	  public JTextField getTxtMostrar() {return txtMostrar;}

	  	
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
		
		txtMostrar = new JTextField();
		txtMostrar.setBounds(90, 10, 554, 161);
		contentPane.add(txtMostrar);
		txtMostrar.setColumns(10);
		
		txtBuscar = new JTextField();
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(96, 202, 125, 19);
		contentPane.add(txtBuscar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(231, 201, 85, 21);
		contentPane.add(btnBuscar);
		
		txtReemplazar = new JTextField();
		txtReemplazar.setColumns(10);
		txtReemplazar.setBounds(390, 202, 141, 19);
		contentPane.add(txtReemplazar);
		
		JButton btnRemplazar = new JButton("Reemplazar");
		btnRemplazar.setBounds(541, 201, 103, 21);
		contentPane.add(btnRemplazar);
		
		txtResultant = new JTextField();
		txtResultant.setEditable(false);
		txtResultant.setColumns(10);
		txtResultant.setBounds(90, 231, 554, 161);
		contentPane.add(txtResultant);
		
		txtDir = new JTextField();
		txtDir.setColumns(10);
		txtDir.setBounds(119, 419, 125, 19);
		contentPane.add(txtDir);
		
		btnCargar = new JButton("Cargar Archivo");
		

		btnCargar.setBounds(254, 418, 125, 21);
		contentPane.add(btnCargar);
		this.setVisible(true);
	}
}
