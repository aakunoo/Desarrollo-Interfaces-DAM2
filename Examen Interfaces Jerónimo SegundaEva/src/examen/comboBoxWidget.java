/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

import examen.comboBoxWidget.Provincia;
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
public class comboBoxWidget extends JComboBox<Provincia>{
    
    
    
    public comboBoxWidget() {
        super(new Provincia[] {
            new Provincia(java.util.ResourceBundle.getBundle("examen/comboBoxWidget").getString("AVILA"), java.util.ResourceBundle.getBundle("examen/comboBoxWidget").getString("AVILA.PNG")),
            new Provincia(java.util.ResourceBundle.getBundle("examen/comboBoxWidget").getString("BURGOS"), java.util.ResourceBundle.getBundle("examen/comboBoxWidget").getString("BURGOS.PNG")),
            new Provincia(java.util.ResourceBundle.getBundle("examen/comboBoxWidget").getString("LEON"), java.util.ResourceBundle.getBundle("examen/comboBoxWidget").getString("LEON.PNG")),
            new Provincia(java.util.ResourceBundle.getBundle("examen/comboBoxWidget").getString("PALENCIA"), java.util.ResourceBundle.getBundle("examen/comboBoxWidget").getString("PALENCIA.PNG")),
            new Provincia(java.util.ResourceBundle.getBundle("examen/comboBoxWidget").getString("SEGOVIA"), java.util.ResourceBundle.getBundle("examen/comboBoxWidget").getString("SEGOVIA.PNG")),
            new Provincia(java.util.ResourceBundle.getBundle("examen/comboBoxWidget").getString("SORIA"), java.util.ResourceBundle.getBundle("examen/comboBoxWidget").getString("SORIA.PNG")),
            new Provincia(java.util.ResourceBundle.getBundle("examen/comboBoxWidget").getString("VALLADOLID"), java.util.ResourceBundle.getBundle("examen/comboBoxWidget").getString("VALLADOLID.PNG")),
            new Provincia(java.util.ResourceBundle.getBundle("examen/comboBoxWidget").getString("ZAMORA"), java.util.ResourceBundle.getBundle("examen/comboBoxWidget").getString("ZAMORA.PNG"))
                    
        });
        setRenderer(new ProvinciaDefaultListCellRenderer());
    }

    public static class Provincia {
        private String nombre;
        private ImageIcon bandera;

        public Provincia(String nombre, String rutaBandera) {
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

    public class ProvinciaDefaultListCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (value instanceof Provincia) {
                Provincia provincia = (Provincia) value;
                label.setText(provincia.getNombre());
                label.setIcon(provincia.getBandera());
                label.setHorizontalTextPosition(JLabel.RIGHT);
                label.setVerticalTextPosition(JLabel.CENTER);
            }
            return label;
        }
    }
}
