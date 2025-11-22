package View;

import Patrones.SistemaFacade;

public class VentanaMenuPrincipal extends javax.swing.JFrame {

    private final SistemaFacade fachada;

    public VentanaMenuPrincipal(SistemaFacade fachada) {
        initComponents();
        this.fachada = fachada;
    }

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {
        new VentanaLoginRegistro(fachada).setVisible(true);
        this.dispose();
    }

    private void btnVisualizacionActionPerformed(java.awt.event.ActionEvent evt) {
        new VentanaLoginVisualizacion(fachada).setVisible(true);
        this.dispose();
    }

    // ... similar para Envio y AdminVoluntarios

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
}
