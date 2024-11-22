/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u4Layouts.teoria;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutHorizontal {

    public static void main(String args[]) {
        
        JFrame ventana = new JFrame("Box Layout Horizontal Demo");
        
        Container container= ventana.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        
        container.add(new JLabel("Etiqueta:"));
        container.add(Box.createRigidArea(new Dimension(10, 0)));
        container.add(new JTextField("Escriba aquí"));
        container.add(Box.createRigidArea(new Dimension(10, 0)));
        container.add(new JButton("Aceptar"));
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);  
    }
}
