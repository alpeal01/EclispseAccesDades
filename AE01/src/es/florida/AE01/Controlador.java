package es.florida.AE01;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JOptionPane;

public class Controlador {
	private Vista vista;
	private Modelo modelo;

	// El constructor rep instancia de la vista i del Modelo
	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		initEventHandlers();
	}

	// Métode per afegir els listeners als elements que els generen (botons)
	public void initEventHandlers() {

		vista.getBtnBusq().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				vista.getList().setListData(modelo.listFich(vista.getTxtBusq().getText()));

				vista.getTxtArMost().setText(modelo.cargaContendio(vista.getTxtBusq().getText()));

			}

		});

		// Métode que permiteix la selecció d'un element de la llista donant click
		vista.getList().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String texto = vista.getTxtBusq().getText(); // ./
				String seleccionado;
				texto.split("/");
				seleccionado = (String) vista.getList().getSelectedValue(); // .classpath
				System.out.println(seleccionado);
				System.out.println(texto.indexOf(seleccionado));
				if (texto.indexOf(seleccionado) >= 0) { // ./.classpath/ == ./.classpath/.classpath/
					System.out.println("Already written");
				} else {
					texto = vista.getTxtBusq().getText() + seleccionado + "/";
					System.out.println(texto);
					vista.getTxtBusq().setText(texto);
				}

			}
		});

		vista.getBtnEncontrar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String[] conetnt = (vista.getTxtArMost().getText().split(" "));
				String textFinal = "";
				String busqWord = vista.getTxtEncontrar().getText();
				for (String word : conetnt) {

					if (word.equals(busqWord)) {

						textFinal += "<H1>" + word + "</H1>";
						textFinal += " ";

					} else {
						textFinal += word;
						textFinal += " ";
					}

				}

				vista.getTxtArMost().setText(textFinal);
				vista.enableList(false);

			}

		});

		vista.getBtnRemplazar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				vista.getTxtArMost().setText(modelo.reemplazar(modelo.cargaContendio(vista.getTxtBusq().getText()),
						vista.getTxtEncontrar().getText(), vista.getTxtReemplazar().getText()));

			}
		});

		// Funció que permiteix crear un fitxer en el directori actual
		vista.getBtnCreacion().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File myObj = new File(vista.getTxtBusq().getText() + vista.getTxtAcciones().getText());
					if (myObj.createNewFile()) {
						System.out.println("File created: " + myObj.getName());
					} else {
						System.out.println("File already exists.");
					}
				} catch (IOException a) {
					System.out.println("An error occurred.");
					a.printStackTrace();
				}
			}
		});

		// Funció que permiteix copiar un fitxer del directori actual
		vista.getBtnCopiar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Comentado por Alvaro para que funcione la otra forma // Me parece muy feo (comentario realizado por Héctor)
				
				File ruta = new File(vista.getTxtBusq().getText() + vista.getTxtAcciones().getText());
				File cp = new File(vista.getTxtBusq().getText() + "copia.txt");
				try {
					Modelo.copiarArch(ruta, cp);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				*/
				
				modelo.dupliArch(vista.getTxtBusq().getText());
			}
		});

		// Funció que permiteix borrar un element
		vista.getBtnBorrar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Seguro que quieres borrar el archivo " + vista.getTxtBusq().getText() );
					
					if(input == 0) {
				
				File f = new File(vista.getTxtBusq().getText());
				System.out.println(f.getPath());
				f.delete();
					}
			}
		});

		// Funció que permiteix renombrar un elemento
		vista.getBtnCNombre().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Seguro que quieres renombrar el Archivo");
				
				if(input == 0) {
					
					//funcion en M O D E L O
					modelo.renombArch(vista.getTxtBusq().getText(),vista.getTxtAcciones().getText());
					
				}
				
			
			}
		});

	}

	/*
	 * public void iniciarVista() { vista = new Vista(); vista.setVisible(true); }
	 */

}
