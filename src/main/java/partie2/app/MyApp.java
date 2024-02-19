package partie2.app;

import partie2.framework.XmlComponentRegistry;
import partie2.framework.AutoInject;
import partie2.framework.DependencyInjector;
import partie2.framework.Injectable;

import partie1.dao.IDao;
import partie1.metier.IMetier;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class MyApp implements Injectable {
    @AutoInject("daoImpl")
    private IDao dao;

    @AutoInject("metierImpl")
    private IMetier metier;

    public void run() {
        metier.calcul();
    }

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        DependencyInjector injector = new DependencyInjector(new XmlComponentRegistry("configFramework.xml"));

        // Création de l'application
        MyApp myApp = new MyApp();

        // Injection des dépendances
        try {
            injector.injectDependencies(myApp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Exécution de l'application
        myApp.run();
    }
}
