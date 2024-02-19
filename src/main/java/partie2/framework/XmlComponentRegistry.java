package partie2.framework;
import javax.xml.bind.*;
import java.io.*;

public class XmlComponentRegistry implements ComponentRegistry {
    private JAXBContext context;
    private Dependencies dependencies;

    public XmlComponentRegistry(String xmlConfigPath) throws JAXBException, FileNotFoundException {
        context = JAXBContext.newInstance(Dependencies.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        dependencies = (Dependencies) unmarshaller.unmarshal(new FileInputStream(xmlConfigPath));
    }

    @Override
    public void registerComponent(String name, Object component) {
        dependencies.getComponents().put(name, component);
    }

    @Override
    public Object getComponent(String name, Class<?> type) {
        return dependencies.getComponents().get(name);
    }
}
