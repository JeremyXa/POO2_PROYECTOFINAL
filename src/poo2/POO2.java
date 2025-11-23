package poo2;

import View.Menu; // o el login que quieras abrir primero
import javax.swing.UIManager;

/**
 * Punto de entrada de la aplicación ADRA.
 */
public class POO2 {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(POO2.class.getName());

    public static void main(String[] args) {

        /* Set Nimbus look and feel */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Crear y mostrar la primera ventana */
        java.awt.EventQueue.invokeLater(() -> {
            // Aquí decides qué ventana es la primera:
            new Menu().setVisible(true);
            // o por ejemplo:
            // new loginRegistro().setVisible(true);
            // new LoginEnvio().setVisible(true);
            // new loginVisualizacion().setVisible(true);
            // new loginRegistroDeVoluntarios().setVisible(true);
        });
    }
}
