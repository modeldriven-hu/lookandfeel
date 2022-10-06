package hu.modeldriven.cameo.lf.action;

import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsCategory;
import com.nomagic.actions.ActionsManager;
import com.nomagic.magicdraw.actions.ActionsID;

public class LFConfigurator implements AMConfigurator {

    private final LFAction lfAction;

    public LFConfigurator(LFAction browserAction) {
        this.lfAction = browserAction;
    }

    @Override
    public void configure(ActionsManager actionsManager) {
        var newProjectAction = actionsManager.getActionFor(ActionsID.OPTIONS);

        if (newProjectAction != null) {
            var category = (ActionsCategory) newProjectAction; //actionsManager.getActionParent(newProjectAction);
            var actionsInCategory = category.getActions();
            actionsInCategory.add(this.lfAction);
            category.setActions(actionsInCategory);
        }
    }

}
