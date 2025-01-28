//-------------------------------------------------------------
// ---------------------- PINTAR EN PANEL ---------------------

private Point anterior = null;

private void formMouseDragged(java.awt.event.MouseEvent evt) {                                  
       if(anterior == null) {
            anterior = evt.getPoint();
            
        } else {
            Graphics graphics = getGraphics();
            graphics.setColor(Color.red);
            graphics.drawLine(anterior.x, anterior.y, evt.getX(), evt.getY());
            anterior = evt.getPoint();
        }
    } 
	
private void formMouseReleased(java.awt.event.MouseEvent evt) { 
	anterior = null;
}
	
//------------------------------------------------------------------------------------------------------
// -------------------- GUARDAR IMAGEN evento formwindowclosing ----------------------------------------

        if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Desea guardar la imagen antes de salir?", "Guardar", JOptionPane.YES_NO_OPTION)){
            JFileChooser dialogoArch = new JFileChooser();
            if (JFileChooser.APPROVE_OPTION == dialogoArch.showSaveDialog(this)){
                File arch = dialogoArch.getSelectedFile();
                try {
                    ImageIO.write(imagen, "jpg", arch);
                } catch (IOException ex) {
                    Logger.getLogger(CirculosAleatorios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        this.dispose();
		
//------------------------------------------------------------------------------------------------------
// -------------------- CIRCULOS ALEATORIOS ----------------------------------------

private BufferedImage imagen;

private void formMouseClicked(java.awt.event.MouseEvent evt) {                                  
        Random rand = new Random();
        int tamano = rand.nextInt(81) + 20;
        Color colorAleatorio = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        Graphics gVentana = getGraphics();
        Graphics gImagen = imagen.getGraphics();
        
        gVentana.setColor(colorAleatorio);
        gImagen.setColor(colorAleatorio);
        gVentana.fillOval(evt.getX() - tamano / 2, evt.getY() - tamano / 2, tamano, tamano);
        gImagen.fillOval(evt.getX() - tamano / 2, evt.getY() - tamano / 2, tamano, tamano);
        
    }  