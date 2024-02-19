package partie2.framework;

import java.util.*;

public class Dependencies {
    private Map<String, Object> components = new HashMap<>();

    public Map<String, Object> getComponents() {
        return components;
    }

    public void setComponents(Map<String, Object> components) {
        this.components = components;
    }
}
