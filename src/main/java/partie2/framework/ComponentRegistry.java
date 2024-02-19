package partie2.framework;
public interface ComponentRegistry {
    void registerComponent(String name, Object component);
    Object getComponent(String name, Class<?> type);
}
