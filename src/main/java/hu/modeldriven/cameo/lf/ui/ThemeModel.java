package hu.modeldriven.cameo.lf.ui;

public class ThemeModel {

    private final String name;
    private final String className;
    private final boolean dark;

    public ThemeModel(String name, String className, boolean dark){
        this.name = name;
        this.className = className;
        this.dark = dark;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public boolean isDark() {
        return dark;
    }
}
