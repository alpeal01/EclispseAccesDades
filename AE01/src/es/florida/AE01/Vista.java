package es.florida.AE01;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;

public class Vista extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusq;
	JTextArea txtArMost;
	JButton btnBusq;
	JList<String> list;

	public JTextArea getTxtArMost() {
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
		setBounds(100, 100, 617, 392);
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

		txtArMost = new JTextArea();
		txtArMost.setEditable(false);
		txtArMost.setBounds(162, 34, 431, 225);
		contentPane.add(txtArMost);

		list = new JList<String>();
		list.setBounds(10, 23, 142, 236);
		contentPane.add(list);

		this.setVisible(true);
	}

}
