package es.florida.AE01;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

	// Mètode per afegir els listeners als elements que els generen (botons)
	public void initEventHandlers() {

		vista.getBtnBusq().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				vista.getList().setListData(modelo.listFich(vista.getTxtBusq().getText()));
				
				vista.getTxtArMost().setText(modelo.cargaContendio(vista.getTxtBusq().getText()));
				

			}

		});
		
//		vista.getList().addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//				String texto = vista.getTxtBusq().getText(); // ./
//				//List<String> listaBusqueda = new ArrayList<String>();
//				String s = (String) vista.getList().getSelectedValue(); // .classpath
//				if (texto.equals(texto + s + "/")) { // ./.classpath/ == ./.classpath/.classpath/
//
//				} else {
//					texto = vista.getTxtBusq().getText() + s + "/";
//					System.out.println(texto);
//					vista.getTxtBusq().setText(texto);
//				}
//
//			}
//		});

		vista.getBtnEncontrar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				

				String [] conetnt = (modelo.cargaContendio(vista.getTxtBusq().getText())).split(" ");
				String textFinal="";
				String busqWord = vista.getTxtEncontrar().getText();
				//<H1><FONT COLOR=white>The text is white</H1>
				for (String word : conetnt) {
					
					if(word.equals(busqWord)) {
						
						textFinal+= "<H1>"+word+"</H1>";
						textFinal+=" ";
						
					}else {
						textFinal+=word;
						textFinal+=" ";
					}
					
				}
				
				
				vista.getTxtArMost().setText(textFinal);
				
				
				

			}

		});
		
		
		
	}

	/*
	 * public void iniciarVista() { vista = new Vista(); vista.setVisible(true); }
	 */
	
	
	

}
