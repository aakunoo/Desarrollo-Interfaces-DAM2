/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u4Layouts.teoria;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutVertical {
    
   public static void main (String[] args) {
       
       JFrame ventana = new JFrame("Box Layout Vertical Demo");
       
       BoxLayout boxLayout = new BoxLayout(ventana.getContentPane(), BoxLayout.Y_AXIS);
       ventana.setLayout(boxLayout);
       
       final short CANTIDAD_ETIQUETAS = 20;
       JLabel etiquetas[] = new JLabel[CANTIDAD_ETIQUETAS];

       for(short i=0; i<CANTIDAD_ETIQUETAS; i++) {
           etiquetas[i] = new JLabel("Etiqueta " + i);
           etiquetas[i].setAlignmentX(Component.CENTER_ALIGNMENT);
           ventana.add(etiquetas[i]);
       }
       
       ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ventana.pack();
       ventana.setVisible(true);
   }
    
}