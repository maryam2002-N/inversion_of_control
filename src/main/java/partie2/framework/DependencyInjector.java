package partie2.framework;

import java.lang.reflect.*;

public class DependencyInjector {
    private ComponentRegistry registry;

    public DependencyInjector(ComponentRegistry registry) {
        this.registry = registry;
    }

    public void register(String name, Object component) {
        registry.registerComponent(name, component);
    }

    public void injectDependencies(Object target) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> targetClass = target.getClass();

        // Injection via attribut (Field)
        Field[] fields = targetClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(AutoInject.class)) {
                injectField(field, target);
            }
        }
    }

    private void injectField(Field field, Object target) throws IllegalAccessException {
        AutoInject annotation = field.getAnnotation(AutoInject.class);
        String componentName = annotation != null ? annotation.value() : "";

        Object component = registry.getComponent(componentName, field.getType());
        field.setAccessible(true);
        field.set(target, component);
    }
}
