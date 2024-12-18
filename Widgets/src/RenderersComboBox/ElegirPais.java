/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RenderersComboBox;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Manana
 */
public class ElegirPais extends JComboBox<ElegirPais.Pais> {

    public ElegirPais() {
        super(new Pais[] {
            new Pais("Estados Unidos", "us.png"),
            new Pais("España", "es.png"),
            new Pais("Francia", "fr.png"),
            new Pais("Italia", "ITA.png"),
            new Pais("Alemania", "de.png")
        });
        setRenderer(new PaisDefaultListCellRenderer());
    }

    public static class Pais {
        private String nombre;
        private ImageIcon bandera;

        public Pais(String nombre, String rutaBandera) {
            this.nombre = nombre;
            this.bandera = new ImageIcon(getClass().getResource(rutaBandera));
        }

        public String getNombre() {
            return nombre;
        }

        public ImageIcon getBandera() {
            return bandera;
        }

        @Override
        public String toString() {
            return nombre; 
        }
    }

    public class PaisDefaultListCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (value instanceof Pais) {
                Pais pais = (Pais) value;
                label.setText(pais.getNombre());
                label.setIcon(pais.getBandera());
                label.setHorizontalTextPosition(JLabel.RIGHT);
                label.setVerticalTextPosition(JLabel.CENTER);
            }
            return label;
        }
    }
}