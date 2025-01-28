
// -------------------------------------------------------------------------------------------------
// ------------------------------ TABLA COLORES ------------------------------

public class TablaColores extends DefaultTableCellRenderer {

    public TablaColores() {
    }
    
  @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component celda = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
        if (!isSelected) {
            if (row % 2 == 0) {
                celda.setBackground(Color.GREEN); 
            } else {
                celda.setBackground(Color.RED); 
            }
        } else {
            celda.setBackground(Color.BLUE); // fila seleccionada
            celda.setForeground(Color.RED);
        }
        return celda;
    }
}

// Para aplicarlo a un proyecto:

import TablaDiferentesColores.TablaColores;

public TablaColoresPractica() { // EN EL CONSTRUCTOR
        TablaColores renderer = new TablaColores();
    
        initComponents();
        
        for(int i=0; i < tabla.getColumnCount(); i++) {
        tabla.getColumnModel().getColumn(i).setCellRenderer(renderer);
    }    
    }
	
	

// -------------------------------------------------------------------------------------------------
// ------------------------------ RENDERER COMBOBOX COLORES ------------------------------

public class ColorComboBox extends JComboBox<Color>{

    public ColorComboBox() {
        this(new Color[] {Color.WHITE, Color.YELLOW, Color.ORANGE, Color.RED, Color.PINK, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA, Color.BLACK});
    }
    
    public ColorComboBox(Color[] colores) {
        super(colores);
        setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) { 
                JLabel l = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                l.setBackground((Color) value);
                l.setText(" ");
                return l;
            }           
        });
        
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground((Color) getSelectedItem());
            }
        });
    }
}

// -------------------------------------------------------------------------------------------------
// ------------------------------ RENDERER COMBOBOX PAISES ------------------------------

public class ElegirPais extends JComboBox<ElegirPais.Pais> {

    public ElegirPais() {
        super(new Pais[] {
            new Pais("Estados Unidos", "us.png"),
            new Pais("España", "es.png"),
            new Pais("Francia", "fr.png"),
            new Pais("Italia", "ITA.png"),
            new Pais("Alemania", "de.png")
        });
        setRenderer(new PaisDefaultListCellRenderer());
    }

    public static class Pais {
        private String nombre;
        private ImageIcon bandera;

        public Pais(String nombre, String rutaBandera) {
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

    public class PaisDefaultListCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (value instanceof Pais) {
                Pais pais = (Pais) value;
                label.setText(pais.getNombre());
                label.setIcon(pais.getBandera());
                label.setHorizontalTextPosition(JLabel.RIGHT);
                label.setVerticalTextPosition(JLabel.CENTER);
            }
            return label;
        }
    }
}

// -------------------------------------------------------------------------------------------------
// ------------------------------ RENDERER COMBOBOX FUENTES SISTEMA ------------------------------


public class FuentesSistema extends JComboBox<Font> {

    public FuentesSistema() {
        super(GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts());
        setRenderer(new FontsDefaultListCellRenderer());
    }
    
    public class FontsDefaultListCellRenderer extends DefaultListCellRenderer{

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel l = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            Font f = (Font) value;
            
            l.setText(f.getName());
            l.setFont(f.deriveFont(16f));
            
            return l;
        }
    }    
}


// -------------------------------------------------------------------------------------------------
// ------------------------------ COMPONENTE DOBLE PASSWORD (JFRAME) ------------------------------

public class DoblePassword extends javax.swing.JPanel {

    public DoblePassword() { // constructor
        initComponents();
            
        jpasswd1.setText("");
        jpasswd2.setText("");
    }

	private void jpasswd2FocusLost(java.awt.event.FocusEvent evt) {                                   
        String contrasena1 = new String(jpasswd1.getPassword());
        String contrasena2 = new String(jpasswd2.getPassword());
        
        
        if(contrasena1.isEmpty()){
            return;
        }
        
        if (contrasena1.equals(contrasena2)) {
            validatelbl.setText("T");
            validatelbl.setForeground(Color.GREEN);
        } else {
            validatelbl.setText("F");
            validatelbl.setForeground(Color.RED);
        }
	}