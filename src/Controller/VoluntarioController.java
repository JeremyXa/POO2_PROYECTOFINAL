package controller;

import java.io.IOException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Localidad;
import model.TareaVoluntario;
import model.Voluntario;
import persistence.VoluntarioTxtAdapter;

public class VoluntarioController {

    private final VoluntarioTxtAdapter adapter;

    public VoluntarioController() {
        this.adapter = new VoluntarioTxtAdapter("voluntarios.txt");
    }

    public void registrarYAsignar(String codigo, String nombreCompleto, String telefono,
                                  String dni, int edad, String correo,
                                  String nombreLocalidad, String tareaDesc) throws IOException {

        Voluntario v = new Voluntario(codigo, nombreCompleto, telefono, dni, edad, correo);
        Localidad loc = new Localidad(nombreLocalidad);
        TareaVoluntario tarea = new TareaVoluntario(v, loc, tareaDesc);
        adapter.guardarRegistro(v, tarea);
    }

    public void refrescarTabla(JTable tabla) throws IOException {
        List<String[]> registros = adapter.cargarTodos();
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Código", "Nombre", "Teléfono", "DNI", "Edad", "Correo", "Localidad", "Tarea"}, 0);
        for (String[] r : registros) {
            model.addRow(r);
        }
        tabla.setModel(model);
    }
}
