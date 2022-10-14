package es.florida.AE01;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;



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

		// Métode que permiteix la selecció d'un element de la llista fent-li click
		vista.getList().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String texto = vista.getTxtBusq().getText(); // ./
				String seleccionado;
				texto.split("/");
				seleccionado = (String) vista.getList().getSelectedValue();
				if (texto.indexOf(seleccionado) >= 0) {
					JOptionPane.showMessageDialog(null, "Ya has realizado esa selección", "Aviso", 0, null);
				} else {
					texto = vista.getTxtBusq().getText() + seleccionado + "/";
					vista.getTxtBusq().setText(texto);

				}
			}
		});

		// Interacció en un botó que serveix per a resaltar una paraula en el text
		vista.getBtnEncontrar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String[] conetnt = (modelo.cargaContendio(vista.getTxtBusq().getText()).split(" "));
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

			}

		});

		// Funció que serveix per a reemplaçar la paraula triada per altra
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
						JOptionPane.showMessageDialog(null, "Archivo creado con éxito");
					} else {
						JOptionPane.showMessageDialog(null, "No se ha podido realizar", "Aviso", 0, null);
					}
				} catch (IOException a) {
					a.printStackTrace();
				}
			}
		});

		// Funció que permiteix copiar un fitxer del directori actual
		vista.getBtnCopiar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				File ruta = new File(vista.getTxtBusq().getText());
				String copia = vista.getTxtBusq().getText();
				if (copia.endsWith("/")) {
					copia = copia.substring(0, copia.length() - 1);
				}
				try {
					File cp = new File(copia + " copia");
					Modelo.copiarArch(ruta, cp);
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
		});

		// Funció que permiteix borrar un element
		vista.getBtnBorrar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null,
						"Seguro que quieres borrar el archivo " + vista.getTxtBusq().getText());

				if (input == 0) {

					File f = new File(vista.getTxtBusq().getText());
					f.delete();
				}
			}
		});

		// Funció que permiteix renombrar un elemento
		vista.getBtnCNombre().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Seguro que quieres renombrar el archivo");

				if (input == 0) {

					// funcion en M O D E L O
					modelo.renombArch(vista.getTxtBusq().getText(), vista.getTxtAcciones().getText());

				}

			}
		});

		// Funció que comprova i canvia la propietat "editable" del JEditorPane
		// txtArMost
		vista.getBtnEscribir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (vista.getTxtArMost().isEditable()) {
					JOptionPane.showMessageDialog(null, "El campo de texto ya está habilitado");
				} else {
					vista.getTxtArMost().setEditable(true);
					JOptionPane.showMessageDialog(null, "Ahora puede escribir en el campo de texto");
				}

			}
		});

		// Funció que guarda i sobrescriu en l'arxiu que s'indique el que s'haja escrit
		// en el txtArMost
		vista.getBtnGuardar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int input = JOptionPane.showConfirmDialog(null, "Quieres guardarlo en un nuevo archivo");

				if (input == 0) {

					String newArch = JOptionPane.showInputDialog("Indica la ruta con el nombre del nuevo archivo");
					if (newArch != null) {

						modelo.guardarcCambios(vista.getTxtArMost().getText(), newArch);
					}

				} else if (input == 1)
					modelo.guardarcCambios(vista.getTxtArMost().getText(),
							vista.getTxtBusq().getText() + vista.getTxtAcciones().getText()); // ¿Es para esto para lo
																								// que sirve?

			}
		});

		// Funció que reinicia tots el camps de text
		vista.getBtnReiniciar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] stringAr = new String[1];
				stringAr[0] = "";

				vista.getTxtBusq().setText("");
				vista.getTxtAcciones().setText("");
				vista.getTxtEncontrar().setText("");
				vista.getTxtReemplazar().setText("");
				vista.getTxtArMost().setText("");
				vista.getList().setListData(stringAr);
			}
		});

	}

	/*
	 * public void iniciarVista() { vista = new Vista(); vista.setVisible(true); }
	 */

}
