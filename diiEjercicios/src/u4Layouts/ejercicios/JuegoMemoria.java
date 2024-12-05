/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package u4Layouts.ejercicios;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.Timer;

/**
 *
 * @author Manana
 */
public class JuegoMemoria extends javax.swing.JFrame {
    
    private final int NUM_CARTAS = 16;
    private ArrayList<Color> colores;
    private ArrayList<JToggleButton> cartas;
    private ArrayList<JToggleButton> seleccionadas;
    private int intentos;
   
    /**
     * Creates new form JuegoMemoria
     */
    public JuegoMemoria() {
        
        initComponents();
        iniciarCartas();
        pack();
        setLocationRelativeTo(null);
        
        Timer cronometro = new Timer(1000, new ActionListener(){
        private int seg = 0;
        @Override
        public void actionPerformed(ActionEvent e){
            seg++;
            int m = seg/60;
            int s = seg%60;
            jLabel1.setText("Tiempo transcurrido: " + ((m<10) ? "0" : "") + m + ":" + ((s<10) ? "0" : "") + s) ;        
        }
        
    });
    cronometro.start();
    }
    private void iniciarCartas(){
        
        Color[] coloresBase = {
            Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW,
            Color.ORANGE, Color.PINK, Color.CYAN, Color.MAGENTA
        };
        
        colores = new ArrayList<>();
        for(Color color : coloresBase){
            colores.add(color);
            colores.add(color); 
        }
        
        Collections.shuffle(colores); // mezclar los colores
        
        cartas = new ArrayList();
        seleccionadas = new ArrayList<>();
        intentos = 0;
        
        actualizarIntentos();

        //jPanel1.setMinimumSize(new Dimension(50,50)); // para darle tamaño inicial a la ventana
        for(int i=0; i<NUM_CARTAS; i++){
            
            JToggleButton carta = new JToggleButton();
            carta.setPreferredSize(new Dimension(50, 50)); // tamaño preferido
            carta.setSelected(true);
            int index = i;
            
            carta.addActionListener(e -> manejarCartaSeleccionada((JToggleButton)e.getSource(), index));

            cartas.add(carta);
            jPanel1.add(carta); // añadir los jtb al jpanel.
        }   
    }
    
        private void manejarCartaSeleccionada(JToggleButton carta, int index) {
        if (seleccionadas.size() < 2 && !seleccionadas.contains(carta)) {
            carta.setBackground(colores.get(index));
            seleccionadas.add(carta);
            
            if (seleccionadas.size() == 2) {
                intentos ++;
                actualizarIntentos();
                comprobarCartas();
            }
        }
    }
        
        private void comprobarCartas() {
        JToggleButton primeraCarta = seleccionadas.get(0);
        JToggleButton segundaCarta = seleccionadas.get(1);
    
        if (primeraCarta.getBackground().equals(segundaCarta.getBackground())) {
            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    primeraCarta.setVisible(false);
                    segundaCarta.setVisible(false);
                    seleccionadas.clear(); 
                    verificarFinJuego();
                }
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    primeraCarta.setBackground(null);
                    segundaCarta.setBackground(null);
                    primeraCarta.setSelected(true);
                    segundaCarta.setSelected(true);
                    seleccionadas.clear();
                    
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
    }
  
    private void verificarFinJuego() {
        boolean todasDesbloqueadas = true; // Asumimos que todas están desbloqueadas

        for (JToggleButton carta : cartas) {
            if (carta.isVisible()) {
                todasDesbloqueadas = false; // Si alguna carta aún es visible, cambiamos a falso
                break; // Salimos del bucle porque ya sabemos que no están todas desbloqueadas
            }
        }

        if (todasDesbloqueadas) {
            JOptionPane.showMessageDialog(this, "¡Enhorabuena! Has completado el juego en " + intentos + " intentos.", "Juego Completado", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

        private void actualizarIntentos() {
        intentosLabel.setText("Intentos: " + intentos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        intentosLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(4, 4));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        intentosLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        intentosLabel.setText("Intentos: ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Tiempo transcurrido:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(intentosLabel))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(intentosLabel)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JuegoMemoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JuegoMemoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JuegoMemoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JuegoMemoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuegoMemoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel intentosLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
