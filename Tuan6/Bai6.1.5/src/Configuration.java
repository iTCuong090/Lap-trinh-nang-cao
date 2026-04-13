import java.util.ArrayList;
import java.util.List;

public class Configuration implements Cloneable {
    private String theme;
    private List<String> plugins;

    public Configuration(String theme, List<String> plugins) {
        this.theme = theme;
        this.plugins = new ArrayList<>(plugins);
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<String> getPlugins() {
        return plugins;
    }

    public void addPlugin(String plugin) {
        this.plugins.add(plugin);
    }

    @Override
    public Configuration clone() {
        try {
            Configuration cloned = (Configuration) super.clone();
            cloned.plugins = new ArrayList<>(this.plugins); // Deep copy thôi, plugin mà có thêm mutable object trong đó thì phải chịu.
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Configuration{theme='" + theme + "', plugins=" + plugins + "}";
    }
}
