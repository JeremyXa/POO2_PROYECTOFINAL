/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Hernan Grados
 */
public enum TipoDonacion {
    ALIMENTOS, ROPA, MUEBLES;

    public static TipoDonacion fromCodigo(String codigo) {
        if (codigo.startsWith("A#")) return ALIMENTOS;
        if (codigo.startsWith("R#")) return ROPA;
        if (codigo.startsWith("M#")) return MUEBLES;
        throw new IllegalArgumentException("Código de donación inválido: " + codigo);
    }
}

