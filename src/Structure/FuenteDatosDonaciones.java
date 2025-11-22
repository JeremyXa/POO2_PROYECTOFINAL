/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structure;

import Model.Donacion;
import java.util.List;

public interface FuenteDatosDonaciones {
    void cargar();                        // cargar desde TXT a Hashtable
    void guardarTodo();                   // escribir Hashtable a TXT
    void agregar(Donacion d);
    void modificar(Donacion d);
    void eliminar(String codigo);
    List<Donacion> listar();
}
