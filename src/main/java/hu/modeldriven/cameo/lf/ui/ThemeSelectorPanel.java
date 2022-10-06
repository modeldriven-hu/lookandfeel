package hu.modeldriven.cameo.lf.ui;

import com.formdev.flatlaf.intellijthemes.FlatAllIJThemes;

import javax.swing.*;
import java.util.Arrays;

public class ThemeSelectorPanel extends BaseThemeSelectorPanel {

    public ThemeSelectorPanel() {
        super();
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
    }

    private void applySelected() {
        var selectedTheme = (ThemeModel) themeSelectorCombobox.getModel().getSelectedItem();

        try {

            var clazz = Class.forName(selectedTheme.getClassName());
            var constructor = clazz.getConstructor();

            UIManager.setLookAndFeel((LookAndFeel) constructor.newInstance());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        //SwingUtilities.updateComponentTreeUI(MDDialogParentProvider.getProvider().getDialogParent(true));
    }

}
