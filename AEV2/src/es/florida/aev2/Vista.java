package es.florida.aev2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Vista extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuery;
	JButton txtExecutar ;
	
	public JButton getTxtExecutar() {
		
		return this.txtExecutar;
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
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtQuery = new JTextField();
		txtQuery.setBounds(203, 20, 437, 27);
		contentPane.add(txtQuery);
		txtQuery.setColumns(10);
		
		JLabel lblConsultas = new JLabel("Consultes: ");
		lblConsultas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConsultas.setBounds(81, 26, 99, 21);
		contentPane.add(lblConsultas);
		
		txtExecutar = new JButton("Executar");
		txtExecutar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtExecutar.setBounds(664, 21, 111, 31);
		contentPane.add(txtExecutar);
		
		JTextArea txtResultats = new JTextArea();
		txtResultats.setBounds(49, 80, 771, 305);
		contentPane.add(txtResultats);
		
		JButton btnTancar = new JButton("Tancar conexió");
		btnTancar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTancar.setBounds(622, 413, 185, 38);
		contentPane.add(btnTancar);
		initComponents();
	}
	
	public void initComponents() {
		setResizable(false);
		setTitle("Aplicació");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		}
}
