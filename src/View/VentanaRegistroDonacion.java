package View;

import Patrones.SistemaFacade;
import Model.Donacion;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VentanaRegistroDonacion extends javax.swing.JFrame {

    private final SistemaFacade fachada;

    public VentanaRegistroDonacion(SistemaFacade fachada) {
        initComponents();
        this.fachada = fachada;
        cargarTabla();
    }

    private void cargarTabla() {
        String[] columnas = {"Código", "Donante", "Descripción", "Fecha", "Cantidad", "Tipo"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        List<Donacion> lista = fachada.obtenerTodasDonaciones();
        for (Donacion d : lista) {
            Object[] fila = {
                d.getCodigo(),
                d.getDonante(),
                d.getDescripcion(),
                d.getFechaIngreso(),
                d.getCantidad(),
                d.getTipo()
            };
            modelo.addRow(fila);
        }
        tablaDonaciones.setModel(modelo);
    }

    // evento del botón Agregar (en NetBeans: ActionPerformed)
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String donante = txtDonante.getText().trim();
            String desc = txtDescripcion.getText().trim();
            String fecha = txtFecha.getText().trim();
            int cant = Integer.parseInt(txtCantidad.getText().trim());
            String codigo = txtCodigo.getText().trim();

            fachada.registrarDonacion(codigo, donante, desc, fecha, cant);
            cargarTabla();  // refrescar JTable
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}