package poo2;

import View.Menu;
import adra.core.AdraController;
import adra.core.DependencyBuilder;

public class POO2 {

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> {
            AdraController controller = DependencyBuilder.buildController();
            new Menu(controller).setVisible(true);
        });
    }
}

