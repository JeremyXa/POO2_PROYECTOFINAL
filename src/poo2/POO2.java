package poo2;

import View.Menu;
import adra.core.AdraController;
import adra.core.DependencyBuilder;

public class POO2 {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(POO2.class.getName());

    public static void main(String[] args) {

        // Configurar Look & Feel Nimbus
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE,
                    "Error configurando Look & Feel Nimbus", ex);
        }

        // Lanzar la app
        java.awt.EventQueue.invokeLater(() -> {
            AdraController controller = DependencyBuilder.buildController();
            new Menu(controller).setVisible(true);
        });
    }
}
