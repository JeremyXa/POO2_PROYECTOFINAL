/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class UsuarioAdmin {
    private String nombre;
    private int pin;

    public UsuarioAdmin(String nombre, int pin) {
        this.nombre = nombre;
        this.pin = pin;
    }

    public String getNombre() { return nombre; }
    public int getPin() { return pin; }
}
