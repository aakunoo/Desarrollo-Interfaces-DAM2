/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClubDeportivo.Modelo;

/**
 *
 * @author Manana
 */
public class Entrenadores extends Personal {

    private double plusPartidoGanado;

    public Entrenadores(String nombre, String dni, String direccion, String telefono, int partidosGanados, double sueldo, double plusPartidoGanado) {
        super(nombre, dni, direccion, telefono, partidosGanados, sueldo);
        this.plusPartidoGanado = plusPartidoGanado;
    }

    @Override
    public double getSueldoFinal() {
        return getSueldo() + (getPartidosGanados() * plusPartidoGanado);
    }

    @Override
    public String toString() {
        return super.toString();
    }
} 

