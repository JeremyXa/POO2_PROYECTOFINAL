/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public abstract class Trabajador {
    private String usuario;
    private String password;
    private String nombre;

    public Trabajador(String usuario, String password, String nombre) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
    }

    public String getUsuario() { return usuario; }
    public String getPassword() { return password; }
    public String getNombre() { return nombre; }
}
