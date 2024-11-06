/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClubDeportivo.Modelo;

/**
 *
 * @author Manana
 */
public class Mantenedores extends Personal {
    
    private boolean fijo;
    private double plusFijo;

    public Mantenedores(String nombre, String dni, String direccion, String telefono, int partidosGanados, double sueldo, boolean fijo, double plusFijo) {
        super(nombre, dni, direccion, telefono, partidosGanados, sueldo);
        this.fijo = fijo;
        this.plusFijo = plusFijo;
    }

    @Override
    public double getSueldoFinal() {
        return fijo ? getSueldo() + plusFijo : getSueldo();
    }

    @Override
    public String toString() {
        return super.toString() + "\nFijo: " + (fijo ? "Sí" : "No");
    }
}
