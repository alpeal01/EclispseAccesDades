package es.florida.AE2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;

public class Cliente extends JFrame {

	private JPanel contentPane;
	private JFrame frame1;
	private JLabel lbl0;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;

	static Socket socket;
	static InputStream is;
	static InputStreamReader isr;
	static BufferedReader bfr;
	static OutputStream os;
	static PrintWriter pw;
	static boolean estado = true;
	static JLabel lbs[] = new JLabel[9];
	static int victoria[][] = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
			{ 0, 4, 8 }, { 2, 4, 6 }, };

	public static void compruebaGanador() {
		for (int i = 0; i < victoria.length; i++) {
			if (lbs[victoria[i][0]].getText().equals("X") && lbs[victoria[i][1]].getText().equals("X")
					&& lbs[victoria[i][2]].getText().equals("X")) {

				lbs[victoria[i][0]].setBackground(Color.lightGray);
				lbs[victoria[i][1]].setBackground(Color.lightGray);
				lbs[victoria[i][2]].setBackground(Color.lightGray);
				estado = false;
				JOptionPane.showMessageDialog(null, "Has ganado, Enhorabuena!");
			}
			if (lbs[victoria[i][0]].getText().equals("O") && lbs[victoria[i][1]].getText().equals("O")
					&& lbs[victoria[i][2]].getText().equals("O")) {

				lbs[victoria[i][0]].setBackground(Color.lightGray);
				lbs[victoria[i][1]].setBackground(Color.lightGray);
				lbs[victoria[i][2]].setBackground(Color.lightGray);
				estado = false;
				JOptionPane.showMessageDialog(null, "Ha ganado Servidor");
			}
		}
	}

	public void mouse(Socket socket) {
		lbl0.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					presiona(0);
					tiradasServidor();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		lbl1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					presiona(1);
					tiradasServidor();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		lbl2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					presiona(2);
					tiradasServidor();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		lbl3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					presiona(3);
					tiradasServidor();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		lbl4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					presiona(4);
					tiradasServidor();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		lbl5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					presiona(5);
					tiradasServidor();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		lbl6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					presiona(6);
					tiradasServidor();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		lbl7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					presiona(7);
					tiradasServidor();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		lbl8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					presiona(8);
					tiradasServidor();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void interfaz() {

		// this.setLocationRelativeTo(null);
		frame1 = new JFrame();
		// frame1.setTitle(turno);
		frame1.setTitle("AE2 3 EN RAYA");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setBounds(100, 100, 385, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(57, 102, 256, 257);
		contentPane.add(panel);

		frame1.getContentPane().add(contentPane);

		lbl0 = new JLabel("");
		lbl0.setBounds(10, 20, 72, 68);
		lbl0.setHorizontalAlignment(SwingConstants.CENTER);
		lbl0.setFont(new Font("Tahoma", Font.BOLD, 36));
		lbl0.setOpaque(true);
		lbl0.setBackground(Color.WHITE);

		lbl1 = new JLabel("");
		lbl1.setBounds(92, 20, 72, 68);
		lbl1.setOpaque(true);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 36));
		lbl1.setBackground(Color.WHITE);

		lbl2 = new JLabel("");
		lbl2.setBounds(174, 20, 72, 68);
		lbl2.setOpaque(true);
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 36));
		lbl2.setBackground(Color.WHITE);

		lbl5 = new JLabel("");
		lbl5.setBounds(174, 99, 72, 68);
		lbl5.setOpaque(true);
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setFont(new Font("Tahoma", Font.BOLD, 36));
		lbl5.setBackground(Color.WHITE);

		lbl4 = new JLabel("");
		lbl4.setBounds(92, 99, 72, 68);
		lbl4.setOpaque(true);
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setFont(new Font("Tahoma", Font.BOLD, 36));
		lbl4.setBackground(Color.WHITE);

		lbl3 = new JLabel("");
		lbl3.setBounds(10, 99, 72, 68);
		lbl3.setOpaque(true);
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("Tahoma", Font.BOLD, 36));
		lbl3.setBackground(Color.WHITE);

		lbl8 = new JLabel("");
		lbl8.setBounds(174, 178, 72, 68);
		lbl8.setOpaque(true);
		lbl8.setHorizontalAlignment(SwingConstants.CENTER);
		lbl8.setFont(new Font("Tahoma", Font.BOLD, 36));
		lbl8.setBackground(Color.WHITE);

		lbl7 = new JLabel("");
		lbl7.setBounds(92, 178, 72, 68);
		lbl7.setOpaque(true);
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		lbl7.setFont(new Font("Tahoma", Font.BOLD, 36));
		lbl7.setBackground(Color.WHITE);

		lbl6 = new JLabel("");
		lbl6.setBounds(10, 178, 72, 68);
		lbl6.setOpaque(true);
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setFont(new Font("Tahoma", Font.BOLD, 36));
		lbl6.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.add(lbl0);
		panel.add(lbl1);
		panel.add(lbl2);
		panel.add(lbl3);
		panel.add(lbl4);
		panel.add(lbl5);
		panel.add(lbl6);
		panel.add(lbl7);
		panel.add(lbl8);

		JLabel lblTitulo = new JLabel("TRES EN RAYA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblTitulo.setBounds(70, 11, 230, 42);
		contentPane.add(lblTitulo);

		this.frame1.setVisible(true);

	}

	public static void tipoNumero() throws IOException {
		os = socket.getOutputStream();
		pw = new PrintWriter(os);
		String respuesta = (JOptionPane.showInputDialog(null,
				"Para saber quien comienza indique si el numero elegido al azar es PAR o IMPAR", "Comienza la partida",
				JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Selecciona", "PAR", "IMPAR" }, "Selecciona"))
				.toString();
		JOptionPane.showMessageDialog(null, "Tu respuesta ha sido: " + respuesta, "Comienza la partida",
				JOptionPane.PLAIN_MESSAGE);

		System.out.println("Cliente envia: " + respuesta);
		pw.print(respuesta + "\n");
		pw.flush();
	}

	public static void inicioJuego() throws IOException {
		is = socket.getInputStream();
		isr = new InputStreamReader(is);
		bfr = new BufferedReader(isr);
		String result = bfr.readLine();
		System.out.println("Resultado: " + result);
		if (result.equals("CLIENTE")) {
			JOptionPane.showMessageDialog(null, "Comienzas a jugar", "Comencemos", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "SERVIDOR comienza a jugar", "Comencemos",
					JOptionPane.INFORMATION_MESSAGE);
			int num = Integer.parseInt(result);
			primeraTiradaServidor(num);
		}
	}

	public static void presiona(int boton) throws IOException {
		os = socket.getOutputStream();
		pw = new PrintWriter(os);
		if (lbs[boton].getText().equals("") && estado) {
			lbs[boton].setText("X");
			System.out.println("CLIENTE >>> introduce X");
			compruebaGanador();
		}

		pw.print(boton + "\n");
		pw.flush();
		System.out.println("CLIENTE >>> Cliente envia posicion: " + boton);
	}

	public static void primeraTiradaServidor(int num) throws IOException {
		lbs[num].setText("O");
		compruebaGanador();
	}

	public static void tiradasServidor() throws IOException {
		System.out.println("Entra");
		bfr = new BufferedReader(isr);
		System.out.println("Entra en tirada Servidor");
		String resultado = bfr.readLine();
		System.out.println("Cliente recibe: " + resultado);
		int boton = Integer.parseInt(resultado);
		if (lbs[boton].getText().equals("") && estado) {
			System.out.println("Cliente gestiona el envio");
			lbs[boton].setText("O");
			compruebaGanador();
		}
		
	}

	public Cliente(Socket socket) {
		interfaz();
		lbs[0] = lbl0;
		lbs[1] = lbl1;
		lbs[2] = lbl2;
		lbs[3] = lbl3;
		lbs[4] = lbl4;
		lbs[5] = lbl5;
		lbs[6] = lbl6;
		lbs[7] = lbl7;
		lbs[8] = lbl8;
		mouse(socket);
		compruebaGanador();
	}

	public static void main(String[] args) throws IOException {

		InetSocketAddress direccion = new InetSocketAddress("localhost", 1234);
		socket = new Socket();
		socket.connect(direccion);
		System.out.println("CLIENTE >>> Arranca cliente");
		System.out.println("CLIENTE >>> Conexion al servidor");
		Cliente client = new Cliente(socket);

		tipoNumero();

		inicioJuego();

		is = socket.getInputStream();
		isr = new InputStreamReader(is);
		bfr = new BufferedReader(isr);

	}
}