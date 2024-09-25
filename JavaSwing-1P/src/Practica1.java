import javax.swing.JFrame;

import javax.swing.JLabel;

  

public class Practica1 {

  

	public static void main(String[] args) {

		// Creación y configuración de la ventana.

		JFrame ventana = new JFrame("Ventanita");

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Creación e inclusión de la etiqueta

		JLabel etiqueta = new JLabel("\u00A1" + "Ejercicio1");

		ventana.add(etiqueta);

		//Establecimiento de la disposición de la ventana

		ventana.setLocation(0,0);

		ventana.setLocationRelativeTo(null);
		
		/*Ventana superior izquierda
		
		ventana.setLocation(0,0);*/
		
		/*Aumentar tamaño ventana
		
		* ventana.setMinimumSize(new Dimension()*/
		
		ventana.setSize(500,500);
		
		ventana.setVisible(true);

	}

  

}