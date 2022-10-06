package hu.modeldriven.cameo.lf.ui;

import javax.swing.*;
import java.awt.*;

public class ThemeSelectorDialog extends JDialog {

    private final ThemeSelectorPanel panel;

    public ThemeSelectorDialog(Frame parent) {
        super(parent, "", false);

        this.panel = new ThemeSelectorPanel();

        this.setContentPane(panel);
        this.pack();

        this.setLocationRelativeTo(parent);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            var dialog = new ThemeSelectorDialog(null);
            dialog.setVisible(true);

        });
    }
}
