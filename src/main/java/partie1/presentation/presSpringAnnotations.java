package partie1.presentation;

import partie1.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class  presSpringAnnotations {
    public static void main(String[] args)  {
        ApplicationContext Context = new AnnotationConfigApplicationContext("dao","metier");
        IMetier metier = Context.getBean(IMetier.class);
        System.out.println("RES="+metier.calcul());
    }
}
