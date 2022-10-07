package hu.modeldriven.cameo.lf.ui;

import com.formdev.flatlaf.intellijthemes.FlatAllIJThemes;
import com.nomagic.magicdraw.ui.dialogs.MDDialogParentProvider;

import javax.swing.*;
import java.util.Arrays;

public class ThemeSelectorPanel extends BaseThemeSelectorPanel {

    private final JDialog dialog;

    public ThemeSelectorPanel(JDialog dialog) {
        super();
        this.dialog = dialog;
        initComponents();
    }

    private void initComponents() {

        var themesModel = new DefaultComboBoxModel<ThemeModel>();

        themesModel.addElement(new ThemeModel("FlatLaf Light", "com.formdev.flatlaf.FlatLightLaf", false));
        themesModel.addElement(new ThemeModel("FlatLaf Dark", "com.formdev.flatlaf.FlatDarkLaf", true));
        themesModel.addElement(new ThemeModel("FlatLaf IntelliJ", "com.formdev.flatlaf.FlatIntelliJLaf", true));
        themesModel.addElement(new ThemeModel("FlatLaf Darcula", "com.formdev.flatlaf.FlatDarkLaf", false));

        Arrays.asList(FlatAllIJThemes.INFOS).forEach(
                item -> themesModel.addElement(
                        new ThemeModel(item.getName(), item.getClassName(), item.isDark())
                )
        );

        themeSelectorCombobox.setModel(themesModel);

        applyButton.addActionListener(e -> applySelected());
        cancelButton.addActionListener(e -> hideDialog());
    }

    private void hideDialog() {
        this.dialog.setVisible(false);
    }

    private void applySelected() {
        try {
            var selectedTheme = (ThemeModel) themeSelectorCombobox.getModel().getSelectedItem();

            var clazz = Class.forName(selectedTheme.getClassName());
            var constructor = clazz.getConstructor();
            var lookAndFeel = (LookAndFeel) constructor.newInstance();

            UIManager.setLookAndFeel(lookAndFeel);
            SwingUtilities.updateComponentTreeUI(SwingUtilities.getWindowAncestor(themeSelectorCombobox));
            SwingUtilities.updateComponentTreeUI(MDDialogParentProvider.getProvider().getDialogParent(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
