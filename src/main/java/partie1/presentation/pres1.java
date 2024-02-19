package partie1.presentation;
import partie1.dao.DaoImpl;
import partie1.metier.MetierImpl;

public class pres1 {
    public static void main(String[] args) {
        DaoImpl dao = new DaoImpl();//instanciation statique
        MetierImpl metier=new MetierImpl(dao);//injection via constructeur
        //metier.setDao(dao);//l'injection des dépendances
        System.out.println("Res ="+ metier.calcul());
    }
}

