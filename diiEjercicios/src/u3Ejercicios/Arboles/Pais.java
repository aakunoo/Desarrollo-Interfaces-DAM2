/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u3Ejercicios.Arboles;

/**
 *
 * @author Manana
 */
public class Pais {

private String nombre;
        private String capital;
        private int poblacion;
        private double pib; // en millones de dólares

        public Pais(String nombre, String capital, int poblacion, double pib) {
            this.nombre = nombre;
            this.capital = capital;
            this.poblacion = poblacion;
            this.pib = pib;
        }

        public String obtenerInformacion() {
            return "Nombre: " + nombre + "\n"
                    + "Capital: " + capital + "\n"
                    + "Población: " + poblacion + "\n"
                    + "PIB: " + pib + " millones de USD";
        }

        @Override
        public String toString() {
            return nombre;
        }
    }