package es.florida.AE01;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JEditorPane;

public class Vista extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusq;
	JButton btnBusq;
	JList<String> list;
	private JTextField txtEncontrar;
	JButton btnEncontrar ;
	private JEditorPane txtArMost;

	public JEditorPane getTxtArMost() {
		return this.txtArMost;
	}

	public JTextField getTxtBusq() {
		return this.txtBusq;
	}

	public JButton getBtnBusq() {
		return this.btnBusq;
	}

	public JList<String> getList() {
		return this.list;
	}
	
	public JButton getBtnEncontrar () {
		
		return this.btnEncontrar;
		
	}
	
	public  JTextField getTxtEncontrar() {
		return this.txtEncontrar;
	}

	public void setList(ArrayList<String> listFich) {
		this.list = new JList<String>(listFich.toArray(new String[listFich.size()]));
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
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String texto = txtBusq.getText(); // ./
				int index = list.getSelectedIndex();
				//List<String> listaBusqueda = new ArrayList<String>();
				String s = (String) list.getSelectedValue(); // .classpath
				if (texto.equals(texto + s + "/")) { // ./.classpath/ == ./.classpath/.classpath/

				} else {
					texto = txtBusq.getText() + s + "/";
					System.out.println(texto);
					txtBusq.setText(texto);
				}

			}
		});
		list.setBounds(10, 34, 142, 225);
		contentPane.add(list);
		
		txtEncontrar = new JTextField();
		txtEncontrar.setBounds(297, 270, 142, 20);
		contentPane.add(txtEncontrar);
		txtEncontrar.setColumns(10);
		
		btnEncontrar = new JButton("Encontrar palabra");
		btnEncontrar.setBounds(449, 269, 139, 23);
		contentPane.add(btnEncontrar);
		
		txtArMost = new JEditorPane();
		txtArMost.setBounds(162, 39, 429, 220);
		contentPane.add(txtArMost);
		txtArMost.setContentType("text/html");

		this.setVisible(true);
	}
}
