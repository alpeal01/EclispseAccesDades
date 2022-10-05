package es.florida.AE01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Vista extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusq;
	JTextArea txtArMost;
	JButton btnBusq;
	
	public JTextArea getTxtArMost() {
		return this.txtArMost;
	}
	
	public JTextField getTxtBusq () {
		return this.txtBusq;
	}
	
	public JButton getBtnBusq() {
		return this.btnBusq;
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
		setBounds(100, 100, 601, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtBusq = new JTextField();
		txtBusq.setBounds(10, 269, 158, 19);
		contentPane.add(txtBusq);
		txtBusq.setColumns(10);
		
		btnBusq = new JButton("Buscar");
		btnBusq.setBounds(178, 268, 85, 21);
		contentPane.add(btnBusq);
		
		txtArMost = new JTextArea();
		txtArMost.setBounds(10, 10, 431, 225);
		contentPane.add(txtArMost);
		
		this.setVisible(true);
	}
}
