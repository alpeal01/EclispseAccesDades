package es.florida.aev2;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;



public class Vista extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuery;
	JButton btnExecutar ;
	JTextArea txtResultats;
	JButton btnObrir;
	JButton btnTancar;
	JButton btnShowT;
	JButton btnShowInfo;
	private JScrollPane scrollPane;
	
	// No crear el setter/getter de ContentPane (hace que la aplicación no funcione)
	
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

	public JTextField getTxtQuery() {
		return txtQuery;
	}

	public void setTxtQuery(JTextField txtQuery) {
		this.txtQuery = txtQuery;
	}

	public JButton getBtnExecutar() {
		return btnExecutar;
	}

	public void setBtnExecutar(JButton btnExecutar) {
		this.btnExecutar = btnExecutar;
	}

	public JTextArea getTxtResultats() {
		return txtResultats;
	}

	public void setTxtResultats(JTextArea txtResultats) {
		this.txtResultats = txtResultats;
	}

	public JButton getBtnObrir() {
		return btnObrir;
	}

	public void setBtnObrir(JButton btnObrir) {
		this.btnObrir = btnObrir;
	}

	public JButton getBtnTancar() {
		return btnTancar;
	}


	
	public JButton getBtnShowT() {
		
		return this.btnShowT;
		
	} 
	
	public JButton getBtnShowInfo() {
		
		return this.btnShowInfo;
		
	} 
	

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
		
		btnExecutar = new JButton("Executar");
		btnExecutar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExecutar.setBounds(665, 20, 111, 31);
		contentPane.add(btnExecutar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 80, 771, 305);
		contentPane.add(scrollPane);
		
		txtResultats = new JTextArea();
		scrollPane.setViewportView(txtResultats);
		txtResultats.setEditable(false);
		
		btnTancar = new JButton("Tancar conexió");
		btnTancar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTancar.setBounds(635, 413, 185, 38);
		contentPane.add(btnTancar);
		
		btnObrir = new JButton("Obrir conexió");
		btnObrir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnObrir.setBounds(440, 413, 185, 38);
		contentPane.add(btnObrir);
		
		btnShowT = new JButton("Mostrar taules");
		btnShowT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnShowT.setBounds(49, 413, 185, 38);
		contentPane.add(btnShowT);
		
		btnShowInfo = new JButton("Info. Taula");
		btnShowInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnShowInfo.setBounds(244, 413, 185, 38);
		contentPane.add(btnShowInfo);
		
		JLabel lblInfoTabla = new JLabel("Indica el nom de la taula en el camp de la consulta");
		lblInfoTabla.setBounds(210, 456, 458, 14);
		contentPane.add(lblInfoTabla);
		initComponents();
	}
	
	public void initComponents() {
		setResizable(false);
		setTitle("Aplicació");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		
		}
}
