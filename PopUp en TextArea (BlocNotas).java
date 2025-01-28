// -------------------------------------------------------------------------------------------------
// ---------------------- COPIAR TODO LO SELECCIONADO AL PORTAPAPELES ----------------------
                                               
        String textoSeleccionado = textArea.getSelectedText();
    if (textoSeleccionado != null) {
        StringSelection seleccion = new StringSelection(textoSeleccionado);
        Clipboard portapapeles = Toolkit.getDefaultToolkit().getSystemClipboard();
        portapapeles.setContents(seleccion, null);
        
        JOptionPane.showMessageDialog(this, "Datos copiados al portapapeles.", 
            "Copiado", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "No hay texto seleccionado para copiar.", 
            "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    
	
	
// -------------------------------------------------------------------------------------------------
// ---------------------- PEGAR LO COPIADO EN EL PORTAPAPELES ----------------------
                                                
    Clipboard portapapeles = Toolkit.getDefaultToolkit().getSystemClipboard();
    Transferable contenido = portapapeles.getContents(null);
    if (contenido != null && contenido.isDataFlavorSupported(DataFlavor.stringFlavor)) {
        try {
            String texto = (String) contenido.getTransferData(DataFlavor.stringFlavor);
            textArea.replaceSelection(texto); 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
// ------------------- SELECCIONAR TODO ------------------------------                                                
        textArea.selectAll();
	
// -------------------------------------------------------------------------------------------------
// ---------------------- BUSCAR UNA PALABRA -------------------------------------------------

private void buscarPalabra() {
    String palabra = JOptionPane.showInputDialog(this, "Introduce la palabra a buscar:", "Buscar palabra", JOptionPane.QUESTION_MESSAGE);

    if (palabra != null && !palabra.trim().isEmpty()) { 
        String texto = textArea.getText(); 
        int index = texto.indexOf(palabra); 

        if (index != -1) { 
            textArea.setSelectionStart(index); 
            textArea.setSelectionEnd(index + palabra.length()); 
            JOptionPane.showMessageDialog(this, "La palabra \"" + palabra + "\" ha sido encontrada y seleccionada.", "Resultado de búsqueda", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "La palabra \"" + palabra + "\" no se encuentra en el texto.", "Resultado de búsqueda", JOptionPane.WARNING_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "No se ingresó ninguna palabra.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// -------------------------------------------------------------------------------------------------
// ---------------------- PONER TIPOGRAFIA -----------------------------
textArea.setFont(new Font("Arial", Font.PLAIN, 14));

// -------------------------------------------------------------------------------------------------
// ---------------------- GUARDAR FICHERO TEXTAREA ----------------------------
JScrollPane scrollPane = (JScrollPane) jTabbedPane1.getSelectedComponent();
    JTextArea textArea = (JTextArea) scrollPane.getViewport().getView();

    JFileChooser fileChooser = new JFileChooser();
    int option = fileChooser.showSaveDialog(this);

    if (option == JFileChooser.APPROVE_OPTION) {
        File archivo = fileChooser.getSelectedFile();

        if (!archivo.getName().toLowerCase().endsWith(".txt")) {
            archivo = new File(archivo.getAbsolutePath() + ".txt");
        }

        try (FileWriter writer = new FileWriter(archivo)) {
            textArea.write(writer); 
            JOptionPane.showMessageDialog(this, "Archivo guardado con éxito", "Guardado", JOptionPane.INFORMATION_MESSAGE);

           
            int selectedTabIndex = jTabbedPane1.getSelectedIndex();
            jTabbedPane1.setTitleAt(selectedTabIndex, archivo.getName());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
// -------------------------------------------------------------------------------------------------
// -------------------- ABRIR FICHERO TEXT AREA ------------------------
JFileChooser fileChooser = new JFileChooser();
    int option = fileChooser.showOpenDialog(this);

    if (option == JFileChooser.APPROVE_OPTION) {
        File archivo = fileChooser.getSelectedFile();
        
        try (FileReader reader = new FileReader(archivo)) {
            JTextArea textArea = new JTextArea();
            textArea.read(reader, null);  // Leer el archivo en el JTextArea

            JScrollPane scrollPane = new JScrollPane(textArea);
            jTabbedPane1.addTab(archivo.getName(), scrollPane);  // Añadir nueva pestaña con el contenido del archivo
            jTabbedPane1.setSelectedComponent(scrollPane);  // Establecer la nueva pestaña como la activa
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al abrir el archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }