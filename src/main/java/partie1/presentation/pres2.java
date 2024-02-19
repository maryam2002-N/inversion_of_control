package partie1.presentation;
import partie1.dao.IDao;
import partie1.metier.IMetier;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class pres2 {
    public static void main(String[] args) throws Exception{
        //DaoImpl dao = new DaoImpl();
        Scanner scanner = new Scanner(new File("config.txt"));
        String daoClassName = scanner.nextLine();
        Class cDao = Class.forName(daoClassName);
        IDao  dao = (IDao) cDao.getConstructor().newInstance();//new DaoImpl()
        System.out.println(dao.getData());
        // MetierImpl metier=new MetierImpl();
        String metierClassName = scanner.nextLine();
        Class cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);
       // metier.setDao(dao);//l'injection des dépendances Statique
        //Method setDao=cMetier.getDeclaredMethod("setDao", IDao.class);
        //setDao.invoke(metier,dao); // Injection des dépendances dynomique
       System.out.println("Res ="+ metier.calcul());
    }
}
