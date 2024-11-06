/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClubDeportivo.Modelo;

/**
 *
 * @author Manana
 */
public class Jugadores extends Personal {
    
    private String posicion;
    private String fechaNacimiento;
    private double plusPartidoGanado;
    private int numeroGoles;
    private double plusPorGol;

    public Jugadores(String nombre, String dni, String direccion, String telefono, int partidosGanados, double sueldo, String posicion, String fechaNacimiento, double plusPartidoGanado, int numeroGoles, double plusPorGol) {
        super(nombre, dni, direccion, telefono, partidosGanados, sueldo);
        this.posicion = posicion;
        this.fechaNacimiento = fechaNacimiento;
        this.plusPartidoGanado = plusPartidoGanado;
        this.numeroGoles = numeroGoles;
        this.plusPorGol = plusPorGol;
    }

    @Override
    public double getSueldoFinal() {
        return getSueldo() + (getPartidosGanados() * plusPartidoGanado) + (numeroGoles * plusPorGol);
    }

    @Override
    public String toString() {
        return super.toString() + "\nPosición: " + posicion + "\nFecha de Nacimiento: " + fechaNacimiento + "\nNúmero de Goles: " + numeroGoles;
    }
}
