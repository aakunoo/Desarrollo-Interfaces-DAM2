/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cronometro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Manana
 */
public class Cronometro extends JLabel{
    Timer temporizador;
    int seg=0;
    
    public Cronometro(){
        super("00:00");
        temporizador = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seg++;
                int m = seg/60;
                int s = seg%60;
                setText( ((m<10) ? "0" : "")+ m + ":" + ((s<10) ? "0" : "") + s);
            }
        });
        
    }
    
    public void start() {
        temporizador.start();
        
    }
    
    public void stop(){
        temporizador.stop();
    }
    
    public void reset(){
        temporizador.restart();
    }
}
