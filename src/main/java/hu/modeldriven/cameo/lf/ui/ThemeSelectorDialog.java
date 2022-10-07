package hu.modeldriven.cameo.lf.ui;

import javax.swing.*;
import java.awt.*;

public class ThemeSelectorDialog extends JDialog {

    private final ThemeSelectorPanel panel;

    public ThemeSelectorDialog(Frame parent) {
        super(parent, "Flat LF themes", false);

        this.panel = new ThemeSelectorPanel(this);

        this.setContentPane(panel);
        this.pack();

        this.setLocationRelativeTo(parent);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

}
