/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClubDeportivo.Modelo;

/**
 *
 * @author Manana
 */
public class Personal {

    
    private String nombre;
    private String dni;
    private String direccion;
    private String telefono;
    private int partidosGanados;
    private double sueldo;
    
     public Personal(String nombre, String dni, String direccion, String telefono, int partidosGanados, double sueldo) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.partidosGanados = partidosGanados;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
               "DNI: " + dni + "\n" +
               "Dirección: " + direccion + "\n" +
               "Teléfono: " + telefono + "\n" +
               "Partidos Ganados: " + partidosGanados + "\n" +
               "Sueldo: " + sueldo;
    }
    
    // Método para calcular el sueldo final (sobrescrito en clases derivadas)
    public double getSueldoFinal() {
        return sueldo;
    }
    
}
