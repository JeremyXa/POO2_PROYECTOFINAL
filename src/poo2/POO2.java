/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo2;

import Patrones.SistemaFacade;
import View.VentanaMenuPrincipal;

public class POO2 {
    public static void main(String[] args) {
        SistemaFacade fachada = new SistemaFacade();
        VentanaMenuPrincipal v = new VentanaMenuPrincipal(fachada);
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }
}
