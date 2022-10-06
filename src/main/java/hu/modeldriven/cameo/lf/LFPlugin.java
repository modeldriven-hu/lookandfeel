package hu.modeldriven.cameo.lf;

import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;
import com.nomagic.magicdraw.plugins.Plugin;
import hu.modeldriven.cameo.lf.action.LFAction;
import hu.modeldriven.cameo.lf.action.LFConfigurator;

public class LFPlugin extends Plugin {

    @Override
    public void init() {
        var action = new LFAction("LFAction", "Flat Look and Feel");
        var configurator = new LFConfigurator(action);
        ActionsConfiguratorsManager.getInstance().addMainMenuConfigurator(configurator);
    }

    @Override
    public boolean close() {
        return true;
    }

    @Override
    public boolean isSupported() {
        return true;
    }
}
