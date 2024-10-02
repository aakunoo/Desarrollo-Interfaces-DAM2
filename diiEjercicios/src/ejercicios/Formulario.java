/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ejercicios;

import com.formdev.flatlaf.FlatDarkLaf;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Manana
 */
public class Formulario extends javax.swing.JFrame {

    /**
     * Creates new form Formulario
     */
    
     // Diccionario para mapear extensiones de teléfono a países (Con ayuda de internet)
    private HashMap<String, String> countryCodes;
     // Variable para saber si estamos limpiando el formulario (para evitar la validación del ciclo)
    private boolean isCleaning = false;
    public Formulario() {
  
        initComponents();
        // Establecer los límites de los JSpinners para la fecha de nacimiento
        jSpinner1.setModel(new SpinnerNumberModel(1, 1, 31, 1)); // Días 1-31
        jSpinner2.setModel(new SpinnerNumberModel(1, 1, 12, 1)); // Meses 1-12
        jSpinner3.setModel(new SpinnerNumberModel(1924, 1924, 2024, 1)); // Años 1924-2024
    
        // Inicializar el diccionario de códigos de país (Ayuda de internet)
        countryCodes = new HashMap<>();
        countryCodes.put("+34", "España");
        countryCodes.put("+1", "EE.UU.");
        countryCodes.put("+44", "Reino Unido");
        countryCodes.put("+49", "Alemania");
        // Se pueden añadir más países si es necesario
    }

 /**
     * Método que valida los campos obligatorios al presionar el botón "Enviar".
     */
 private boolean validarFormulario() {
        // Validar campos obligatorios (nombre, apellidos, NIF, dirección, teléfono, email, ciclo, turno)
        if (jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty() ||
            jTextField3.getText().isEmpty() || jTextField4.getText().isEmpty() ||
            jTextField5.getText().isEmpty() || jTextField6.getText().isEmpty() ||
            jComboBox1.getSelectedIndex() == 0 || jComboBox2.getSelectedIndex() == 0) {

            JOptionPane.showMessageDialog(this, "Por favor, rellena todos los campos obligatorios.", "Campos obligatorios", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // Validar teléfono de contacto (reconociendo extensiones internacionales) (Internet)
        String telefono = jTextField5.getText();
        String codigoPais = telefono.split("\\s+")[0]; // Obtener el código del país

        if (!countryCodes.containsKey(codigoPais)) {
            JOptionPane.showMessageDialog(this, "Extensión de teléfono no válida. Ejemplo: +34 para España.", "Teléfono incorrecto", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Validar el formato del teléfono después del código de país
        if (!telefono.matches("\\+\\d{2}\\s?\\d{9}$")) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un número de teléfono válido con la extensión correcta (Ejemplo: +34 612345678).", "Teléfono incorrecto", JOptionPane.WARNING_MESSAGE);
            return false;
        }
                // Validar el formato del correo electrónico
        String email = jTextField6.getText();
        if (!email.matches("^(.+)@(gmail|yahoo|outlook|hotmail)\\.(com|es)$")) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un correo electrónico válido (Ej: gmail.com, yahoo.com).", "Correo incorrecto", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Validar el formato del NIF/DNI (8 números y 1 letra)
        String nif = jTextField3.getText();
        if (!nif.matches("^[0-9]{8}[A-Za-z]$")) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un NIF/DNI válido (Ej: 12345678A).", "NIF/DNI incorrecto", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Este método limpia todos los campos del formulario.
     */
  private void limpiarFormulario() {
      isCleaning = true; // Activamos la bandera de limpieza
        jTextField1.setText(""); // Limpiar campo "Nombre"
        jTextField2.setText(""); // Limpiar campo "Apellidos"
        jTextField3.setText(""); // Limpiar campo "NIF"
        jTextField4.setText(""); // Limpiar campo "Dirección"
        jTextField5.setText(""); // Limpiar campo "Teléfono"
        jTextField6.setText(""); // Limpiar campo "Email"
        jComboBox1.setSelectedIndex(0); // Reiniciar selección de "Ciclo"
        jComboBox2.setSelectedIndex(0); // Reiniciar selección de "Turno"
        jSpinner1.setValue(0); // Reiniciar día (vacío)
        jSpinner2.setValue(0); // Reiniciar mes (vacío)
        jSpinner3.setValue(0); // Reiniciar año (vacío)
        jCheckBox1.setSelected(false); // Desmarcar "Ajedrez"
        jCheckBox2.setSelected(false); // Desmarcar "Futbol Sala"
        jCheckBox3.setSelected(false); // Desmarcar "Baloncesto"
        isCleaning = false; // Desactivamos la bandera de limpieza
    }

  /**
     * Este método crea un archivo .txt con los datos del formulario al presionar "Enviar".
     */
    private void generarArchivo() throws IOException {
        // Crear el archivo en el directorio del proyecto
        File file = new File(System.getProperty("user.dir"), "datos_formulario.txt");

        try (FileWriter escritor = new FileWriter(file)) {
            escritor.write("Nombre: " + jTextField1.getText() + "\n");
            escritor.write("Apellidos: " + jTextField2.getText() + "\n");
            escritor.write("NIF: " + jTextField3.getText() + "\n");
            escritor.write("Dirección: " + jTextField4.getText() + "\n");
            escritor.write("Teléfono: " + jTextField5.getText() + "\n");
            escritor.write("Email: " + jTextField6.getText() + "\n");
            escritor.write("Ciclo: " + jComboBox1.getSelectedItem() + "\n");
            escritor.write("Turno: " + jComboBox2.getSelectedItem() + "\n");
            escritor.write("Actividades extraescolares: " +
                         (jCheckBox1.isSelected() ? "Ajedrez " : "") +
                         (jCheckBox2.isSelected() ? "Futbol Sala " : "") +
                         (jCheckBox3.isSelected() ? "Baloncesto" : "") + "\n");
        }
        JOptionPane.showMessageDialog(this, "Los datos han sido guardados en un archivo de texto en el directorio del proyecto.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

        /**
     * Método para validar la fecha de nacimiento (evitar día 31 en meses con 30 días).
     */
    private void validarFechaNacimiento() {
        int dia = (int) jSpinner1.getValue();
        int mes = (int) jSpinner2.getValue();

        // Si el mes es abril, junio, septiembre o noviembre, y el día es 31, resetear el día
        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia == 31) {
            JOptionPane.showMessageDialog(this, "Este mes no tiene 31 días. Ajustando el día a 30.", "Fecha no válida", JOptionPane.WARNING_MESSAGE);
            jSpinner1.setValue(30); // Ajustar el día a 30
        }

        // Validar febrero (mes 2), ajustar días según si es bisiesto o no
        if (mes == 2) {
            int año = (int) jSpinner3.getValue();
            if (año % 4 == 0 && año % 100 != 0 || año % 400 == 0) { // Año bisiesto
                if (dia > 29) {
                    JOptionPane.showMessageDialog(this, "Febrero en año bisiesto solo tiene 29 días. Ajustando el día a 29.", "Fecha no válida", JOptionPane.WARNING_MESSAGE);
                    jSpinner1.setValue(29); // Ajustar a 29
                }
            } else { // Año no bisiesto
                if (dia > 28) {
                    JOptionPane.showMessageDialog(this, "Febrero solo tiene 28 días en año no bisiesto. Ajustando el día a 28.", "Fecha no válida", JOptionPane.WARNING_MESSAGE);
                    jSpinner1.setValue(28); // Ajustar a 28
                }
            }
        }
    }
    
        /**
     * Método para configurar el autocompletado del campo de dirección.
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblform = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        setForeground(java.awt.Color.darkGray);

        lblform.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblform.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblform.setText("Formulario de matriculación alumnos FP.");

        jSeparator1.setForeground(new java.awt.Color(255, 153, 153));

        jTextField1.setToolTipText("Introduce tu nombre");
        jTextField1.setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Apellidos:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("NIF:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Direccion:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Fecha de nacimiento:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Telefono de contacto:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Email:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Ciclo:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Turno:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Actividades extraescolares:");

        jTextField2.setToolTipText("Introduce tu/s apellido/s");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setToolTipText("Introduce tu DNI/NIF");

        jTextField4.setToolTipText("Introduce tu dirección");

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField5.setToolTipText("Introduce tú tlf de contacto.");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField6.setToolTipText("Introduce tu email");
        jTextField6.setDoubleBuffered(true);

        jSpinner1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jSpinner1FocusGained(evt);
            }
        });

        jSpinner2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jSpinner2FocusGained(evt);
            }
        });

        jSpinner3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jSpinner3FocusGained(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "Desarrollo de Aplicaciones Multiplataforma", "Desarrollo Web", "Marketing", "Sistemas y Redes" }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "Matutino", "Vespertino" }));

        jCheckBox1.setText("Ajedrez");

        jCheckBox2.setText("Futbol Sala");

        jCheckBox3.setText("Baloncesto");

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblform, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField1))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(304, 304, 304)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(23, 23, 23)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(23, 23, 23)
                                .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(23, 23, 23)
                                .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(15, 15, 15))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinner1)
                                .addGap(27, 27, 27)
                                .addComponent(jSpinner2)
                                .addGap(27, 27, 27)
                                .addComponent(jSpinner3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblform, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
            String telefono = jTextField5.getText(); // Obtener el valor del campo de teléfono
    String codigoPais = telefono.split("\\s+")[0]; // Obtener el código del país (ejemplo: +34)

    // Validar que la extensión del país está en el diccionario
    if (!countryCodes.containsKey(codigoPais)) {
        JOptionPane.showMessageDialog(this, "Extensión de teléfono no válida. Ejemplo: +34 para España.", "Teléfono incorrecto", JOptionPane.WARNING_MESSAGE);
        return; // No continuar si la extensión es incorrecta
    }

    // Validar el formato del teléfono completo (Ejemplo: +34 612345678)
    if (!telefono.matches("\\+\\d{2}\\s?\\d{9}$")) {
        JOptionPane.showMessageDialog(this, "Por favor, introduce un número de teléfono válido con la extensión correcta (Ejemplo: +34 612345678).", "Teléfono incorrecto", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
          if (isCleaning) {
            // Si estamos limpiando, no hacer la validación del ciclo
            return;
        }

        if (jComboBox1.getSelectedItem().equals("---")) {
            JOptionPane.showMessageDialog(this, "Selecciona un ciclo válido, la opción '---' no está permitida.", "Ciclo no válido", JOptionPane.WARNING_MESSAGE);
            jComboBox1.setSelectedIndex(0); // Reiniciar la selección
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         limpiarFormulario(); // Llamar al método para limpiar el formulario directamente
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Validar los campos y generar el archivo si todo es válido
        if (validarFormulario()) {
            try {
                validarFechaNacimiento(); // Verificar que la fecha sea válida
                generarArchivo(); // Generar el archivo con los datos
                limpiarFormulario(); // Limpiar el formulario automáticamente sin preguntar
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jSpinner1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jSpinner1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner1FocusGained

    private void jSpinner2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jSpinner2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner2FocusGained

    private void jSpinner3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jSpinner3FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner3FocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            try {
                UIManager.setLookAndFeel( new FlatDarkLaf() );
            } catch( UnsupportedLookAndFeelException ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
                new Formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lblform;
    // End of variables declaration//GEN-END:variables

}
