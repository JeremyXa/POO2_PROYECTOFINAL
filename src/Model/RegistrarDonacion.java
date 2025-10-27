/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author USUARIO
 */
public class RegistrarDonacion {
    
    private String name;
    private String color;
    private boolean termsAccepted;

    public RegistrarDonacion (String name, String color, boolean termsAccepted) {
        this.name = name;
        this.color = color;
        this.termsAccepted = termsAccepted;
    }

    public String getName() { return name; }
    public String getPhone() { return color; }
    public boolean isTermsAccepted() { return termsAccepted; }
}