package View;

import Patrones.SistemaFacade;

public class VentanaLoginRegistro extends javax.swing.JFrame {

    private final SistemaFacade fachada;

    public VentanaLoginRegistro(SistemaFacade fachada) {
        initComponents();
        this.fachada = fachada;
    }

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {
        String user = txtUsuario.getText().trim();
        String pass = new String(txtPassword.getPassword());

        if (fachada.loginRegistro(user, pass)) {
            VentanaRegistroDonacion v = new VentanaRegistroDonacion(fachada);
            v.setLocationRelativeTo(null);
            v.setVisible(true);
            this.dispose();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Usuario o contraseña incorrectos para REGISTRO");
        }
    }

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {
        VentanaMenuPrincipal m = new VentanaMenuPrincipal(fachada);
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.dispose();
    }
}
