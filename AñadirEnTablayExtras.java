// -------------------------------------------------------------------------------------------------
// ------------------------------ SALIR DE LA APP ------------------------------

int respuesta = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas salir?", "Confirmación", JOptionPane.YES_NO_OPTION);
    if (respuesta == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
	
// -------------------------------------------------------------------------------------------------
// ------------------------------ CAMBIAR FONDO ------------------------------

private void menuitemFondoActionPerformed(java.awt.event.ActionEvent evt) {                                              
Color color = JColorChooser.showDialog(this, "Elige un color", getContentPane().getBackground());
    if (color != null) {
        getContentPane().setBackground(color);
        jTable1.setBackground(color);
    }
}

// -------------------------------------------------------------------------------------------------
// ------------------------------ PONER ICONO EN EL JFRAME ------------------------------
	initComponents();
	setIconImage(new ImageIcon(getClass().getResource("/logo.png")).getImage());

// -------------------------------------------------------------------------------------------------
// ------------------------------ AÑADIR COMBO BOX EN TABLA ------------------------------

 tabla.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JComboBox<>(new String []{"Unionistas", "Valencia", "Madrid", "Betis", "Barcelona"})));
 
// -------------------------------------------------------------------------------------------------
// ------------------------------ AÑADIR CHECK BOX EN TABLA ------------------------------
 
 tabla.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new JCheckBox("prueba")));
 
 
// -------------------------------------------------------------------------------------------------
// ------------------------------ AÑADIR SPINNER EN TABLA ------------------------------
 private void annadirSpinner() {
        TableColumn columnaSpinner = tabla.getColumnModel().getColumn(1);
        columnaSpinner.setCellEditor(new DefaultCellEditor(new JTextField()){
            JSpinner sp = new JSpinner();
            
            @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            sp.setValue(value != null ? value : 0);
            return sp;
        }
        @Override
        public Object getCellEditorValue() {
            return sp.getValue();
        }
    });     
    }
	