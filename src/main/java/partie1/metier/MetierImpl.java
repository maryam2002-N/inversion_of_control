package partie1.metier;

import partie1.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {

    private IDao dao;//couplage faible
    public  MetierImpl(IDao dao){
        this.dao = dao;
    }
    @Override
    public double calcul() {
        double d = dao.getData();
        double res = d * 11.4;
        return res;
    }

    /*
     * Pour permettre d'injecter dans la variable dao
     * un objet d'une classe qui implémente 1'interface IDao
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
