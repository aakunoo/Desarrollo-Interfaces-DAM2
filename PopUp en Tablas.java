// -------------------------------------------------------------------------------------------------
// ------------------------------ MENÚ POPUP EN TABLA ------------------------------

private Point puntoPopUp;

private void tablaMouseReleased(java.awt.event.MouseEvent evt) { 
        // para saber exactamente en que fila pulsa el usuario.
        //if(evt.isPopupTrigger()){ // esto quiere decir que sólo va a ir si es pulsado el 3 boton del raton. (click derecho)
            puntoPopUp = evt.getPoint(); // para obtener punto pulsado 
        //}   
    }   

// Eliminar fila tabla.
private void menuItemEliminarActionPerformed(java.awt.event.ActionEvent evt) {

	int [] filas = tabla.getSelectedRows();
        if(filas.length>0){
            for(int i = filas.length-1; i>=0; i--){
            ((DefaultTableModel)tabla.getModel()).removeRow(filas[i]);
            }
        }
    }  
	
// Exportar Tablas seleccionadas.
 private void menuItemExportarActionPerformed(java.awt.event.ActionEvent evt) {                                                 
       
    int[] filas = tabla.getSelectedRows();
    if (filas.length > 0) {
        StringBuilder datosExportados = new StringBuilder();
        for (int fila : filas) {
            for (int columna = 0; columna < tabla.getColumnCount(); columna++) {
                datosExportados.append(tabla.getValueAt(fila, columna)).append("\t");
            }
            datosExportados.append("\n");
        }

        try {
            FileWriter escritor = new FileWriter("datos_exportados.txt");
            escritor.write(datosExportados.toString());
            escritor.close();
            JOptionPane.showMessageDialog(this, "Datos exportados correctamente a 'datos_exportados.txt'.", "Exportación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (java.io.IOException e) {
            JOptionPane.showMessageDialog(this, "Error al exportar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "No hay filas seleccionadas para exportar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }   
    }  
	
// Mostrar donde se pulsa.
private void menuPulsarActionPerformed(java.awt.event.ActionEvent evt) {                                               
        JOptionPane.showMessageDialog(this, "Ha pulsado sobre el punto\n" + "X: " + puntoPopUp.getX() + 
                "\n" + "Y: " + puntoPopUp.getY() + "\n" + "Fila: " + tabla.rowAtPoint(puntoPopUp) + "\n" + "Columna: " + tabla.columnAtPoint(puntoPopUp));
        
    }  
	
// Seleccionar todas las tablas.
 private void menuItemSelectAllActionPerformed(java.awt.event.ActionEvent evt) {
        tabla.selectAll();  
    }   
	

// Copiar al portapapeles.

private void menuCopiarActionPerformed(java.awt.event.ActionEvent evt) {                                           
    int[] filas = tabla.getSelectedRows();
    
    if (filas.length > 0) {

        StringBuilder contenido = new StringBuilder();
        
        for (int fila : filas) {
            for (int columna = 0; columna < tabla.getColumnCount(); columna++) {
                Object valorCelda = tabla.getValueAt(fila, columna);
                if (valorCelda != null) {
                    contenido.append(valorCelda.toString());
                }
                if (columna < tabla.getColumnCount() - 1) {
                    contenido.append("\t");
                }
            }
            contenido.append("\n");
        }  
        StringSelection ss = new StringSelection(contenido.toString());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        
        JOptionPane.showMessageDialog(this, "Datos copiados al portapapeles.", 
            "Copiado", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "No hay filas seleccionadas para copiar.", 
            "Advertencia", JOptionPane.WARNING_MESSAGE);
    }  
    }  


// Insertar fila con formato.
private void menuInsertarActionPerformed(java.awt.event.ActionEvent evt) {                  
       String lineaAnnadida = (String)JOptionPane.showInputDialog(this, "Añade en formato a,1,2,3");
       String [] array = lineaAnnadida.split(",");
      
       ((DefaultTableModel)tabla.getModel()).insertRow(tabla.rowAtPoint(puntoPopUp), new Object[]{array[0], array[1], array[2], array[3]});
    }
	
	
// Insertar fila vacía.
private void InsertarFilaVaciaActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        int filaSeleccionada = tabla.rowAtPoint(puntoPopUp);
    
    if (filaSeleccionada != -1) { // Comprobar si hay una fila válida seleccionada
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.insertRow(filaSeleccionada + 1, new Object[tabla.getColumnCount()]);
    } else {
        JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna fila.", 
            "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    }

