package hu.modeldriven.cameo.lf.action;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.ui.dialogs.MDDialogParentProvider;
import hu.modeldriven.cameo.lf.ui.ThemeSelectorDialog;

import java.awt.event.ActionEvent;

public class LFAction extends MDAction {

    private final ThemeSelectorDialog dialog;

    public LFAction(String id, String name) {
        super(id, name, null, null);
        var parent = MDDialogParentProvider.getProvider().getDialogParent(true);
        this.dialog = new ThemeSelectorDialog(parent);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.dialog.setVisible(true);
    }
}
