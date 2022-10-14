package es.florida.AE01;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusq;
	JButton btnBusq;
	JList<String> list;
	private JTextField txtEncontrar;
	JButton btnEncontrar;
	private JEditorPane txtArMost;
	private JButton btnCopiar;
	private JButton btnCNombre;
	private JButton btnBorrar;
	JButton btnRemplazar;
	private JTextField txtReemplazar;
	private JTextField txtAcciones;
	JButton btnCreacion;
	JButton btnGuardar;
	JButton btnEscribir;
	private JButton btnReiniciar;

	public JEditorPane getTxtArMost() {
		return this.txtArMost;
	}

	public JTextField getTxtBusq() {
		return this.txtBusq;
	}
	
	public JTextField getTxtAcciones() {
		return txtAcciones;
	}

	public void setTxtAcciones(JTextField txtAcciones) {
		this.txtAcciones = txtAcciones;
	}

	public JButton getBtnBusq() {
		return this.btnBusq;
	}

	public JList<String> getList() {
		return this.list;
	}

	public JButton getBtnEncontrar() {

		return this.btnEncontrar;

	}

	public JTextField getTxtEncontrar() {
		return this.txtEncontrar;
	}

	public void setList(ArrayList<String> listFich) {
		this.list = new JList<String>(listFich.toArray(new String[listFich.size()]));
	}

	// Intento de hacer que la jlist no funcione cuando mostramos información de un
	// archivo (¿funciona?)
	public void enableList(boolean t) {
		this.list.setEnabled(t);
	}
	
	
	public JButton getBtnReiniciar() {
		return btnReiniciar;
	}

	public void setBtnReiniciar(JButton btnReiniciar) {
		this.btnReiniciar = btnReiniciar;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnEscribir() {
		return btnEscribir;
	}

	public void setBtnEscribir(JButton btnEscribir) {
		this.btnEscribir = btnEscribir;
	}

	public JButton getBtnRemplazar() {

		return this.btnRemplazar;

	}
	
	public JTextField getTxtReemplazar() {
		return this.txtReemplazar;
	}
	
	public JButton getBtnCopiar() {
		return btnCopiar;
	}

	public void setBtnCopiar(JButton btnCopiar) {
		this.btnCopiar = btnCopiar;
	}
	
	public JButton getBtnCreacion() {
		return btnCreacion;
	}

	public void setBtnCreacion(JButton btnCreacion) {
		this.btnCreacion = btnCreacion;
	}
	
	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	public JButton getBtnCNombre() {
		return btnCNombre;
	}

	public void setBtnCNombre(JButton btnCNombre) {
		this.btnCNombre = btnCNombre;
	}

	
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Vista frame = new Vista();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	

	/**
	 * Create the frame.
	 */
	public Vista() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtBusq = new JTextField();
		txtBusq.setBounds(162, 5, 336, 19);
		contentPane.add(txtBusq);
		txtBusq.setColumns(10);

		btnBusq = new JButton("Buscar");
		btnBusq.setBounds(508, 4, 85, 21);
		contentPane.add(btnBusq);

		list = new JList<String>();
		list.setBounds(10, 39, 142, 220);
		contentPane.add(list);

		txtEncontrar = new JTextField();
		txtEncontrar.setBounds(297, 270, 142, 20);
		contentPane.add(txtEncontrar);
		txtEncontrar.setColumns(10);

		btnEncontrar = new JButton("Encontrar palabra");
		btnEncontrar.setBounds(449, 269, 139, 23);
		contentPane.add(btnEncontrar);

		txtArMost = new JEditorPane();
		txtArMost.setEditable(false);
		txtArMost.setBounds(162, 39, 429, 220);
		contentPane.add(txtArMost);
		txtArMost.setContentType("text/html");

		btnCopiar = new JButton("Copiar");
		btnCopiar.setBounds(131, 270, 89, 23);
		contentPane.add(btnCopiar);

		btnCNombre = new JButton("Cambiar nombre");
		btnCNombre.setBounds(109, 303, 133, 23);
		contentPane.add(btnCNombre);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(10, 304, 89, 23);
		contentPane.add(btnBorrar);

		btnRemplazar = new JButton("Reemplazar");
		btnRemplazar.setBounds(449, 303, 139, 23);
		contentPane.add(btnRemplazar);
		
		txtReemplazar = new JTextField();
		txtReemplazar.setColumns(10);
		txtReemplazar.setBounds(297, 304, 142, 20);
		contentPane.add(txtReemplazar);
		
		txtAcciones = new JTextField();
		txtAcciones.setBounds(10, 340, 232, 20);
		contentPane.add(txtAcciones);
		txtAcciones.setColumns(10);
		
		btnCreacion = new JButton("Crear");
		btnCreacion.setBounds(10, 269, 89, 23);
		contentPane.add(btnCreacion);
		
		btnEscribir = new JButton("Escribir");
		btnEscribir.setBounds(319, 337, 89, 23);
		contentPane.add(btnEscribir);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(433, 337, 89, 23);
		contentPane.add(btnGuardar);
		
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setBounds(32, 4, 89, 23);
		contentPane.add(btnReiniciar);

		this.setVisible(true);
	}
}
