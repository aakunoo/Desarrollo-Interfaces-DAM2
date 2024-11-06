/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClubDeportivo.Modelo;

/**
 *
 * @author Manana
 */
public class Directivo extends Personal {
    
    private String cargo;
    private boolean activo;
    
    public Directivo(String nombre, String dni, String direccion, String telefono, int partidosGanados, double sueldo) {
        super(nombre, dni, direccion, telefono, partidosGanados, sueldo);
        
        this.cargo=cargo;
        this.activo=activo;
    }
        @Override
    public String toString() {
        return super.toString() + "\nCargo: " + cargo + "\nActivo: " + (activo ? "Sí" : "No");
    }
}
