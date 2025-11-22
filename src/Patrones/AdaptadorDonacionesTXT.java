/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Patrones;

import Structure.TablaHashDonaciones;
import Model.Donacion;
import Structure.FuenteDatosDonaciones;
import java.io.*;
import java.util.List;

public class AdaptadorDonacionesTXT implements FuenteDatosDonaciones {

 private final TablaHashDonaciones tabla;
    private final String archivo = "donaciones.txt";

    public AdaptadorDonacionesTXT(TablaHashDonaciones tabla) {
        this.tabla = tabla;
        cargar();
    }

    @Override
    public void cargar() {
        tabla.limpiar();
        File f = new File(archivo);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // formato: codigo;donante;descripcion;fecha;cantidad;tipo
                String[] p = linea.split(";");
                if (p.length >= 6) {
                    Donacion d = new Donacion(
                        p[0], p[1], p[2], p[3],
                        Integer.parseInt(p[4]),
                        Model.TipoDonacion.valueOf(p[5])
                    );
                    tabla.insertar(d);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void guardarTodo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Donacion d : tabla.obtenerTodas()) {
                pw.println(d.getCodigo() + ";" +
                           d.getDonante() + ";" +
                           d.getDescripcion() + ";" +
                           d.getFechaIngreso() + ";" +
                           d.getCantidad() + ";" +
                           d.getTipo().name());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void agregar(Donacion d) {
        tabla.insertar(d);
        guardarTodo();
    }

    @Override
    public void modificar(Donacion d) {
        tabla.insertar(d);
        guardarTodo();
    }

    @Override
    public void eliminar(String codigo) {
        tabla.eliminar(codigo);
        guardarTodo();
    }

    @Override
    public List<Donacion> listar() {
        return tabla.obtenerTodas();
    }
}
