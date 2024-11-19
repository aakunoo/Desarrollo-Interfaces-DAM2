/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

import java.util.List;

/**
 *
 * @author Manana
 */
public class Ropa {
    List<String>talla;
    private String sexo;
    private String categoria;
    private String nommbre;
    private String codigo;
    private int cantidad;

    public Ropa(List<String> talla, String sexo, String categoria, String nommbre, String codigo, int cantidad) {
        this.talla = talla;
        this.sexo = sexo;
        this.categoria = categoria;
        this.nommbre = nommbre;
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    public List<String> getTalla() {
        return talla;
    }

    public void setTalla(List<String> talla) {
        this.talla = talla;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNommbre() {
        return nommbre;
    }

    public void setNommbre(String nommbre) {
        this.nommbre = nommbre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
